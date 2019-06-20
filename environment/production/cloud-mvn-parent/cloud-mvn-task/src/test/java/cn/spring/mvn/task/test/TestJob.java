package cn.spring.mvn.task.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.basic.util.BasicUtil;
import cn.spring.mvn.system.entity.SysDate;
import cn.spring.mvn.system.entity.service.SysDateService;

public class TestJob {
	@Autowired
	private SysDateService systemDateServiceImpl;
	public void tips(){  
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String hqlStr = "from SystemDate where date_type = 'system'";
		List<SysDate> systemDateList = systemDateServiceImpl.findAllByHql(hqlStr);
		SysDate systemDate = systemDateList.get(0);
		System.out.println("-----数据库中toDay是------" + systemDate.getToday());
		String today = systemDate.getToday();
		String newToDay = BasicUtil.getDateStrByDateStrAddDays(today, 1);
		systemDate.setTheDayBeforeYesterday(BasicUtil.getDateStrByDateStrAddDays(newToDay,-2));
		systemDate.setYesterday(BasicUtil.getDateStrByDateStrAddDays(newToDay,-1));
		systemDate.setToday(newToDay);
		systemDate.setTomorrow(BasicUtil.getDateStrByDateStrAddDays(newToDay,1));
		systemDate.setTheDayAfterTomorrow(BasicUtil.getDateStrByDateStrAddDays(newToDay,2));
		systemDateServiceImpl.saveOrUpdate(systemDate);
		String time = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println("time:"+time);  
    }  
}
