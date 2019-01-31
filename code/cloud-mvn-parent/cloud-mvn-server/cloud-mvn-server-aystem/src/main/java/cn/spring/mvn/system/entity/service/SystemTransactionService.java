package cn.spring.mvn.system.entity.service;

import cn.spring.mvn.system.entity.SystemTransaction;
import cn.spring.mvn.basic.hibernat.HibernatService;

public interface SystemTransactionService extends HibernatService<SystemTransaction>{
	public abstract SystemTransaction selectOne(String prcscd, String trantp);
}
