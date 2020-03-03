package cn.spring.mvn.client.web.model.repository;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysRole;
import cn.spring.mvn.client.web.model.primarykey.SifSysRolePk;

@Service("SifSysRoleRepository")
public interface SifSysRoleRepository extends Repository<SifSysRole, SifSysRolePk> {

}
