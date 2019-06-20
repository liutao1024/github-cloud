package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;
import cn.spring.mvn.system.entity.SysRole;
import cn.spring.mvn.system.entity.service.SysRoleService;

@Service("SysRoleService")
public class SysRoleServiceImpl extends HibernateServiceImpl<SysRole> implements SysRoleService{
	@Override
	public SysRole selectOneByPrimeKey(String regist_cd, String auth_type, String role_cd){
		SysRole sysRole = new SysRole(regist_cd, auth_type, role_cd);
		return this.selectOneEntity(sysRole);
		
	}
	
}
