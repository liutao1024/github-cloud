package cn.spring.mvn.task.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.system.entity.SysBatchTaskTimer;
import cn.spring.mvn.system.entity.service.SysBatchTaskTimerService;
import cn.spring.mvn.task.util.TaskJobUtil;

/**
 * @author LiuTao @date 2018年11月2日 上午9:13:42
 * @ClassName: TaskJob 
 * @Description: 定时任务调度器
 */
public class TaskJob implements Job{
	@Autowired
	private SysBatchTaskTimerService sysBatchTaskTimerServiceImpl = SpringContextUtil.getBean(SysBatchTaskTimerService.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//获取调度器中设置的值
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		//根据调度状态为RUNING的定时调度控制器获取批量任务控制器中的任务执行标志为'Y'的批量任务
		SysBatchTaskTimer taksTimer = (SysBatchTaskTimer) jobDataMap.get("jobTimer");
		TaskJobUtil.executeJob(taksTimer);
	}

}
