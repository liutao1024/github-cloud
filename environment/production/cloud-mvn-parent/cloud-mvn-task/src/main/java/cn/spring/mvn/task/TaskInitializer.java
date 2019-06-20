package cn.spring.mvn.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.basic.tools.BasicReflection;
import cn.spring.mvn.system.entity.SysBatchTaskControl;
import cn.spring.mvn.system.entity.SysBatchTaskTimer;
import cn.spring.mvn.system.entity.service.SysBatchTaskControlService;
import cn.spring.mvn.system.entity.service.SysBatchTaskTimerService;
import cn.spring.mvn.system.entity.service.SysDateService;
/**
 * @author LiuTao @date 2018年6月2日 下午5:21:19
 * @ClassName: BatchJob 
 * @Description:项目启动时,执行此定时任务,在本任务中将其他的定时任务按启动起来
 * 				启动时在SystemBatchTimeDispathControl中,获取定时任务的配置并将任务添加起来
 */
public class TaskInitializer{
	private static final Logger LOGGER = Logger.getLogger(TaskInitializer.class);
	
	@Autowired
	private SysDateService sysDateServiceImpl;//系统时间
	@Autowired
	private SysBatchTaskTimerService sysBatchTaskTimerServiceImpl;//任务定时器
	@Autowired
	private SysBatchTaskControlService sysBatchTaskControlServiceImpl;//批量任务控制器
	/**
	 * @author LiuTao @date 2018年6月3日 下午12:50:23 
	 * @Title: initializeBatch 
	 * @Description: 项目启动时,这个方法配置spring-quartz.xml中作为定时任务启动,频率为一分钟执行一次(0 * * * * ?)
	 * 					通过这个定时任务对系统中其他的批量任务组/定时任务做:
	 * 							1.初始化
	 * 							2.改变调度时间
	 * 							3.关闭(暂未实现)
	 * 时间到了执行定时任务***JobGroup**.java
	 */		
	public void initializeTasks(){
		try {
			/**
			 * 1.处理批量任务组
			 */
			// 1.1.将所有调度状态为START的批量任务组的状态修改为RUNING
			String hqlStr_StatusStart = "from SysBatchTaskControl where JOB_GROUP_STATUS = 'START'";
			List<SysBatchTaskControl> SysBatchTaskControlStatusStartList = 
					sysBatchTaskControlServiceImpl.findAllByHql(hqlStr_StatusStart);
			for (SysBatchTaskControl entity : SysBatchTaskControlStatusStartList) {
				entity.setJobGroupStatus("RUNING");
			}
			sysBatchTaskControlServiceImpl.updateEntities(SysBatchTaskControlStatusStartList);
			
			// 1.2.将所有调度状态为STOP的批量任务组的状态修改为STOPPED
			String hqlStr_StatusStop = "from SysBatchTaskControl where JOB_GROUP_STATUS = 'STOP'";
			List<SysBatchTaskControl> SysBatchTaskControlStatusStopList = 
					sysBatchTaskControlServiceImpl.findAllByHql(hqlStr_StatusStop);
			for (SysBatchTaskControl entity : SysBatchTaskControlStatusStopList) {
				entity.setJobGroupStatus("STOPPED");
				//需要将这些定时任务从内存中删除   20181112
				String jobGroupName = entity.getJobGroupName();
				String jobGroupNumber = entity.getJobGroupNumber();
				TaskManager.removeJob(jobGroupName, jobGroupNumber);
			}
			sysBatchTaskControlServiceImpl.updateEntities(SysBatchTaskControlStatusStopList);
			
			// 1.3.获取所有状态为RUNING的批量任务组, 将每个状态为RUNING 批量任务组作为一个定时任务添加到Spring容器中
			String hqlStr_StatusRuning = "from SysBatchTaskControl where JOB_GROUP_STATUS = 'RUNING' order by JOB_GROUP_NUMBER";
			List<SysBatchTaskControl> SysBatchTaskControlStatusRuningList = 
					sysBatchTaskControlServiceImpl.findAllByHql(hqlStr_StatusRuning);
			for (SysBatchTaskControl entity : SysBatchTaskControlStatusRuningList) {
				String jobGroupName = entity.getJobGroupName();
				String jobGroupNumber = entity.getJobGroupNumber();
				String year = entity.getJobGroupPeriodYear();
				String week = entity.getJobGroupPeriodWeek();
				String month = entity.getJobGroupPeriodMonth();
				String day = entity.getJobGroupPeriodDay();
				String hour = entity.getJobGroupPeriodHour();
				String minute = entity.getJobGroupPeriodMinute();
				String second = entity.getJobGroupPeriodSecond();
				//此处的clazzName为固定的TaskManager.java
				String clazzName = "cn.spring.mvn.task.job.TaskJobGroup";//批量任务组的入口类
//				String clazzName = triggerGroupPath + CommUtil.DOT + triggerGroupModule + CommUtil.JOB + triggerGroupClass;//定时任务的入口类
				//是否可以利用反射将batchJob转换成类BatchJob1001------可以的20180602
				//systemBatchTimeDispathControlStatusRuning获得corn的规则
				String  cron = (second == null ? "*": second) +" "+ (minute == null ? "*": minute) +" "+ (hour == null ? "*":hour) +" "+  
						(day == null ? "*":day) +" "+ (month == null ? "":month) +" "+ (week == null ? "":week) +" "+ (year == null ? "*":year);
				cron = "0/30 * * * * ?";//每分钟的每15秒执行一次  ----具体的cron配置不太懂,需要看一看
				try {
					Class<?> jobClazz = BasicReflection.getClassByReflectClassName(clazzName);
					//添加或修改定时任务
					TaskManager.addOrModifyJobByCron(jobClazz, jobGroupName, jobGroupNumber, cron, null);
					// TODO:登记成功信息
				} catch (Exception e) {
					// TODO:登记异常信息
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
			/**
			 * 2.处理定时任务 JOB_GROUP_NUMBER = '91'
			 */
			// 2.1 将定时任务表(SysBatchTaskTimer)中状态为Y的任务取出, 作为一个定时任务添加到Spring容器中
			String hqlStr_Flag_Y = "from SysBatchTaskTimer where JOB_GROUP_NUMBER = '10091' and JOB_EXECUTE_FLAG = 'Y'";
			List<SysBatchTaskTimer> sysBatchTaskTimerFlagYList = sysBatchTaskTimerServiceImpl.findAllByHql(hqlStr_Flag_Y);
			for (SysBatchTaskTimer entity : sysBatchTaskTimerFlagYList) {
				String clazzName = "cn.spring.mvn.task.job.TaskJob";//定时任务入口类
				try {
					Class<?> jobClazz = BasicReflection.getClassByReflectClassName(clazzName);
					//添加或修改定时任务
					TaskManager.addOrModifyJobByTaskTimer(jobClazz, entity);
					// TODO:登记成功信息
				} catch (Exception e) {//登记异常信息
					LOGGER.info(e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			e.printStackTrace();
		}
	}
}
