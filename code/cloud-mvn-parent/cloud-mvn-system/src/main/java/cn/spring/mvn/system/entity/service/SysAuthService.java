package cn.spring.mvn.system.entity.service;

import java.util.List;

import cn.spring.mvn.basic.hibernate.HibernateService;
import cn.spring.mvn.system.entity.SysAuth;

public interface SysAuthService extends HibernateService<SysAuth>{
	public List<SysAuth> queryEntitiesByEntityParamMap(SysAuth sysAuth);
}
