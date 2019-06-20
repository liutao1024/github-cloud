package cn.spring.mvn.task.job.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.basic.util.BasicUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.system.entity.SysDate;
import cn.spring.mvn.system.entity.service.SysDateService;
import cn.spring.mvn.system.tools.SequenceTool;

public class TaskJobTask{
	
	@Autowired
	private static SysDateService sysDateServiceImpl = SpringContextUtil.getBean(SysDateService.class);
	
	public static void executeOne() throws Exception {
		try {
			List<SysDate> dateList = sysDateServiceImpl.findAllByHql("from SysDate where date_type = 'system'");
			for (SysDate systemDate : dateList) {
				System.out.println("-----executeOne-----systemDate.toDay:"+systemDate.getToday());
				String s = SequenceTool.getSequence("ELECTRON");
				String a = SequenceTool.getSequence("CUSTOMER");
				String b = SequenceTool.getSequence("ACCOUNT");
				System.out.println("------liutao-----" + s);
				System.out.println("------liutao-----" + a);
				System.out.println("------liutao-----" + b);
			}
		} catch (Exception e) {
			System.out.println("-----executeOne-----Exception:"+ e);
			throw e;
		}
	}

	public static void executeTwo() throws Exception {
		List<SysDate> dateList = sysDateServiceImpl.findAllByHql("from SysDate where date_type = 'acca'");//会计
		for (SysDate accaDate : dateList) {
			System.out.println("-----executeTwo-----accaDate.toDay:"+accaDate.getToday());
		}
	}
	
	public static void changeDate() throws ParseException{
		SysDate coreDate = sysDateServiceImpl.findOneByHql("from SysDate where date_type = 'system'");
		String coreToDay = coreDate.getToday();
		SysDate accaDate = sysDateServiceImpl.findOneByHql("from SysDate where date_type = 'acca'");
		String accaToDay = accaDate.getToday();
		System.out.println("-----changeDate-----coreToDay:" + coreToDay);
		System.out.println("-----changeDate-----accaToDay:" + accaToDay);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		coreDate.setTheDayBeforeYesterday(BasicUtil.getDateStrByDateStrAddDays(coreDate.getTheDayBeforeYesterday(), 1));
		coreDate.setYesterday(BasicUtil.getDateStrByDateStrAddDays(coreDate.getYesterday(), 1));
		coreDate.setToday(BasicUtil.getDateStrByDateStrAddDays(coreDate.getToday(), 1));
		coreDate.setTomorrow(BasicUtil.getDateStrByDateStrAddDays(coreDate.getTomorrow(), 1));
		coreDate.setTheDayAfterTomorrow(BasicUtil.getDateStrByDateStrAddDays(coreDate.getTheDayAfterTomorrow(), 1));
		
		accaDate.setTheDayBeforeYesterday(BasicUtil.getDateStrByDateStrAddDays(accaDate.getTheDayBeforeYesterday(), 1));
		accaDate.setYesterday(BasicUtil.getDateStrByDateStrAddDays(accaDate.getYesterday(), 1));
		accaDate.setToday(BasicUtil.getDateStrByDateStrAddDays(accaDate.getToday(), 1));
		accaDate.setTomorrow(BasicUtil.getDateStrByDateStrAddDays(accaDate.getTomorrow(), 1));
		accaDate.setTheDayAfterTomorrow(BasicUtil.getDateStrByDateStrAddDays(accaDate.getTheDayAfterTomorrow(), 1));
		
		sysDateServiceImpl.saveOrUpdate(coreDate);
		sysDateServiceImpl.saveOrUpdate(accaDate);
//		BasicUtil.getDateStrByDateStrAddDays(coreToDay, 1);
//		Date d1 = DateTool.addDays(sdf.parse(coreToDay), 1);
//		Date d2 = DateTool.addDays(sdf.parse(coreToDay), 1);
		
	}
}
