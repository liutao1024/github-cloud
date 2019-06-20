package cn.spring.mvn.client.web.model.repository;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysUser;
import cn.spring.mvn.client.web.model.primarykey.SifSysUserPk;

@Service("SifSysUserRepository")
public interface SifSysUserRepository extends Repository<SifSysUser, SifSysUserPk>{
	
}
