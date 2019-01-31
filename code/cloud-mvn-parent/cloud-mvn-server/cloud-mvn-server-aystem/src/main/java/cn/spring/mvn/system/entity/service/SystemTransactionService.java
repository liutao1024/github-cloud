package cn.spring.mvn.system.entity.service;

import cn.spring.mvn.system.entity.SystemTransaction;
import cn.spring.mvn.basic.hibernate.HibernateService;

public interface SystemTransactionService extends HibernateService<SystemTransaction>{
	public abstract SystemTransaction selectOne(String prcscd, String trantp);
}
