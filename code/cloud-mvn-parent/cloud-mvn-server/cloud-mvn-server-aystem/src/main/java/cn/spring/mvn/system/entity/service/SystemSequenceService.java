package cn.spring.mvn.system.entity.service;

import cn.spring.mvn.system.entity.SystemSequence;
import cn.spring.mvn.basic.hibernate.HibernateService;

public interface SystemSequenceService extends HibernateService<SystemSequence>{
	public abstract SystemSequence selectOne(String sequenceType);
}
