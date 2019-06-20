package cn.spring.mvn.system.entity.service;

import cn.spring.mvn.system.entity.SysTransaction;
import cn.spring.mvn.basic.hibernate.HibernateService;

public interface SysTransactionService extends HibernateService<SysTransaction>{
	public abstract SysTransaction selectOne(String prcscd, String trantp);
}
