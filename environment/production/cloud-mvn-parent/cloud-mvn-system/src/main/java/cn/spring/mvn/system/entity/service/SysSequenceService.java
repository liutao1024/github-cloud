package cn.spring.mvn.system.entity.service;

import cn.spring.mvn.system.entity.SysSequence;
import cn.spring.mvn.basic.hibernate.HibernateService;

public interface SysSequenceService extends HibernateService<SysSequence>{
	public abstract SysSequence selectOne(String sequenceType);
}
