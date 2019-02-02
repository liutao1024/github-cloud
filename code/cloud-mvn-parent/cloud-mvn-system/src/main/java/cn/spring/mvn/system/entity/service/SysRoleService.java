package cn.spring.mvn.system.entity.service;

import cn.spring.mvn.basic.hibernate.HibernateService;
import cn.spring.mvn.system.entity.SysRole;

public interface SysRoleService extends HibernateService<SysRole> {
	public SysRole selectOneByPrimeKey(String regist_cd, String auth_type, String role_cd);
}
