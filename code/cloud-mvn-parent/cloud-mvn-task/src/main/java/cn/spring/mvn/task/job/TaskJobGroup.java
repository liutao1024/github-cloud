package cn.spring.mvn.task.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.system.entity.SysBatchTaskTimer;
import cn.spring.mvn.system.entity.service.SysBatchTaskTimerExecuteResultService;
import cn.spring.mvn.system.entity.service.SysBatchTaskTimerService;
import cn.spring.mvn.task.util.TaskJobUtil;
/**
 * @author LiuTao @date 2019年2月2日 上午10:57:40
 * @ClassName: TaskJobGroup 
 * @Description: 批量任务组调度器
 */
public class TaskJobGroup implements Job{

	@Autowired
	private SysBatchTaskTimerService sysBatchTaskTimerServiceImpl = SpringContextUtil.getBean(SysBatchTaskTimerService.class);
	@Autowired
	private SysBatchTaskTimerExecuteResultService sysBatchTaskTimerExecuteResultServiceImpl = SpringContextUtil.getBean(SysBatchTaskTimerExecuteResultService.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		System.out.println(systemBatchTaskDispathControlImpl);
//		System.out.println(systemBatchTimeTaskDispathResultServiceImpl);
		/**测试是否可以通过反射执行类中的方法---成功的*/
//		String className = "cn.spring.mvn.global.comm.batch.task.impl.BatchTask0001";
//		String methodName = "executeOne";
//		Class[] es = {};
//		Object[] o = {};
//		try {
//			BatchTools.executeMethodByClassNameAndMethodName(className, methodName, es, o);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		/**20180603测试使用jdbc访问数据库----成功的*/
//		try {
//        	String sql = "select * from sys_batch_task_control where TRIGGER_GROUP_NUMBER = '10001' and JOB_EXECUTE_FLAG = 'Y'";
//        	Connection connection = DBTool.getConnection();
//        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
// 			ResultSet resultSet = preparedStatement.executeQuery();
// 			List<SystemBatchTaskDispathControl>  list = new ArrayList<SystemBatchTaskDispathControl>();
// 			if(resultSet.next()){
// 				SystemBatchTaskDispathControl task = new SystemBatchTaskDispathControl();
// 				task.setTRIGGER_GROUP_NUMBER(resultSet.getString("TRIGGER_GROUP_NUMBER"));
// 				task.setJOB_GROUP_NUMBER(resultSet.getString("JOB_GROUP_NUMBER"));
// 				task.setJOB_GROUP_CLASS_NAME(resultSet.getString("JOB_GROUP_CLASS_NAME"));
// 				task.setJOB_GROUP_METHOD_NAME(resultSet.getString("JOB_GROUP_METHOD_NAME"));
// 				task.setJOB_DESCRIPTION(resultSet.getString("JOB_DESCRIPTION"));
// 				task.setJOB_EXECUTE_TIME(resultSet.getString("JOB_EXECUTE_TIME"));
// 				task.setJOB_EXECUTE_FLAG(resultSet.getString("JOB_EXECUTE_FLAG"));
// 				list.add(task);
// 			}
// 			System.out.println("List<SystemBatchTaskDispathControl>  list.size:"+list.size());
// 			for (SystemBatchTaskDispathControl systemBatchTaskDispathControl : list) {
// 				String jobGroupClassName = "cn.spring.mvn.global.comm.batch.task.impl." + systemBatchTaskDispathControl.getJOB_GROUP_CLASS_NAME();
// 				String jobGroupMethodName = systemBatchTaskDispathControl.getJOB_GROUP_METHOD_NAME();
// 				System.out.println("jobGroupClassName:"+jobGroupClassName);
// 				System.out.println("jobGroupMethodName:"+jobGroupMethodName);
// 				Class[] classes = {};
// 				Object[] objects = {};
//				BatchTools.executeMethodByClassNameAndMethodName(jobGroupClassName, jobGroupMethodName, classes, objects);
//			}
//		}catch(Exception e){
//			System.out.println("-------BatchJob10001.Exception----------"+e.getMessage());
//		}
// 			SystemBatchTaskDispathControl list = systemDateList.get(0) ;
// 	        String today = systemDate.getToday();
// 	        String newToDay = CommUtil.toGetDateStrByDateStr(today, 1);
// 	        String theDayBeforeYesterday = CommUtil.toGetDateStrByDateStr(newToDay,-2);
// 	        String yesterday = CommUtil.toGetDateStrByDateStr(newToDay,-1);
// 	        String todayNew = newToDay;
// 	        String tomorrow = CommUtil.toGetDateStrByDateStr(newToDay,1);
// 	        String theDayAfterTomorrow = CommUtil.toGetDateStrByDateStr(newToDay,2);
		
		
		/**使用heibrnt访问数据库----在访问数据库时就不执行了--
		 * 通过继承父类BatchManger在实例化Service时,调用父类的getService()方法,获取实例化对象
		 *  这样就能获取到Spring容器中的bean对象
		 *  想办法service实例化时不需要调用父类的方法
		 *  在父类中直接搞好,子类中还像之前那样写
		 *  		可以考虑反射取到注解来进行实例化
		 *  父类中能取到所有的子类吗?
		 *  ------这样子运行到子类时同样为null,由于父类中通过反射实例化一个子类并给子类属性赋值成功,
		 *  当定时任务执行到子类时是实例化的一个新的子类,所以同样为空,可以考虑的是实现单列模式??????
		 * */
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();//获取不了值  取不到值是因为设值的时间点不对
		//根据调度状态为RUNING的定时调度控制器获取批量任务控制器中的任务执行标志为'Y'的批量任务
		String JOB_GROUP_NUMBER = (String) jobDataMap.get("jobGroupNumber");//
		//获取该批次所有需要执行的Task(方法)有序的---需要根据JOB_NUMBER排序
		String hqlStr_Flage_Y = "from SysBatchTaskTimer where JOB_GROUP_NUMBER = '" + JOB_GROUP_NUMBER + "' and JOB_EXECUTE_FLAG = 'Y' order by JOB_NUMBER asc" ;
//		System.out.println(hqlStr_Flage_Y);
		List<SysBatchTaskTimer> SysBatchTaskTimerList = sysBatchTaskTimerServiceImpl.findAllByHql(hqlStr_Flage_Y);
//		System.out.println(SysBatchTaskTimerList.size());
		for (SysBatchTaskTimer sysBatchTaskTimer : SysBatchTaskTimerList) {
			TaskJobUtil.executeJob(sysBatchTaskTimer);
		}
	}

}
