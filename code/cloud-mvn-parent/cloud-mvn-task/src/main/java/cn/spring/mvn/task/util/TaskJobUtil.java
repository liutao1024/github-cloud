package cn.spring.mvn.task.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.basic.tools.BasicReflection;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.system.entity.SysBatchTaskTimer;
import cn.spring.mvn.system.entity.SysBatchTaskTimerExecuteResult;
import cn.spring.mvn.system.entity.service.SysBatchTaskTimerExecuteResultService;
/**
 * @author LiuTao @date 2019年2月2日 下午2:26:50
 * @ClassName: TaskJobUtil 
 * @Description: 定时任务工具类
 */
public class TaskJobUtil {
	//是否能取到值还不确定,若取不到值那么在调用的地方传入也是可以从20190202
	@Autowired
	private static SysBatchTaskTimerExecuteResultService serviceImpl = SpringContextUtil.getBean(SysBatchTaskTimerExecuteResultService.class);
	/**
	 * @author LiuTao @date 2019年2月2日 下午2:04:21 
	 * @Title: executeJob 
	 * @Description: 通过发射找到类调用对应的方法 
	 * @param taksTimer
	 * @param jobClazzName
	 * @param jobMethodName
	 * @param jobExecuteTime
	 * @param serviceImpl
	 */
	public static void executeJob(SysBatchTaskTimer taksTimer) {
		//根据taksTimer的JOB_EXECUTE_FLAG来判断是否执行
		String JobExecuteFlag = taksTimer.getJobExecuteFlag();
		if(CommUtil.isNotNull(JobExecuteFlag) && CommUtil.equal("Y", JobExecuteFlag)){
			String status = "";
			String message = "";
			String jobClazzName = taksTimer.getJobPath() + CommUtil.DOT + taksTimer.getJobModule() + CommUtil.JOBIMPL + taksTimer.getJobClass();
			String jobMethodName = taksTimer.getJobMethod();
			int jobExecuteTime = taksTimer.getJobExecuteTime();
			Class<?>[] clazzes = {};
			Object[] objects = {}; 
			try {
				for(int i = 0; i < jobExecuteTime; i++){//根据定时任务表(SysBatchTaskTimer)中的执行次数重复执行
					BasicReflection.executeMethodByReflectClassNameAndMethodName(jobClazzName, jobMethodName, clazzes, objects);
				}
				// TODO:登记执行成功信息
				status = "SUCCESS";
			} catch (Exception e) {//异常信息
				e.printStackTrace();
				message = e.getMessage();
				status = "ERROR";
			} finally {
				SysBatchTaskTimerExecuteResult entity = new SysBatchTaskTimerExecuteResult();
				try {
					entity.setJobNumber(taksTimer.getJobNumber());
					entity.setJobName(taksTimer.getJobName());
					entity.setJobGroupNumber(taksTimer.getJobGroupNumber());
					entity.setJobGroupName(taksTimer.getJobGroupName());
					entity.setJobExecuteDate(new Date());
					entity.setJobExecuteMessage(message);
					entity.setJobExecuteStatus(status);
					entity.setJobExecuteTimestamp(String.valueOf(System.currentTimeMillis()));
					serviceImpl.saveEntity(entity);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}
}
