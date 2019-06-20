package cn.spring.mvn.system.entity.service;

import java.util.List;

import cn.spring.mvn.basic.hibernate.HibernateService;
import cn.spring.mvn.system.entity.SysUser;

public interface SysUserService extends HibernateService<SysUser>{

	SysUser add(SysUser entity) throws Exception;
	
	void delete(SysUser entity);
	
	SysUser selectOneByPrimeKey(String registCd, String userid);
	
	List<SysUser> selectAll();
	
	List<SysUser> selectAllByRegistCd(String registCd);
	
	void update(SysUser entity);

	long count();

}