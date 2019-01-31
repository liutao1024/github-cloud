package cn.spring.mvn.web.entity.service;

import cn.spring.mvn.basic.hibernate.HibernateService;
import cn.spring.mvn.web.entity.SysRole;

public interface SysRoleService extends HibernateService<SysRole> {
	public SysRole selectOneByPrimeKey(String regist_cd, String auth_type, String role_cd);
}
