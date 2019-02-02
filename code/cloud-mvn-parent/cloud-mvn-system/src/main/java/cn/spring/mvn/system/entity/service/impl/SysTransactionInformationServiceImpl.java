package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysTransactionInformation;
import cn.spring.mvn.system.entity.service.SysTransactionInformationService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SysTransactionInformationService")
public class SysTransactionInformationServiceImpl extends HibernateServiceImpl<SysTransactionInformation> implements SysTransactionInformationService{
//
//	@Resource 
//	private SysTransactionInformationDao sysTransactionInformationDao;
//	@Override
//	public List<SysTransactionInformation> selectSysTransactionInformationList() {
//		return sysTransactionInformationDao.selectSysTransactionInformationList();
//	}
//	@Override
//	public int insertSysTransactionInformation(SysTransactionInformation sysTransactionInformation) {
//		return sysTransactionInformationDao.insertSysTransactionInformation(sysTransactionInformation);
//	}
	
}
