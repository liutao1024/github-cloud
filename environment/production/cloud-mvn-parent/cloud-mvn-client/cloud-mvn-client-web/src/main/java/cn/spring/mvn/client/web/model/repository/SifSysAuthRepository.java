package cn.spring.mvn.client.web.model.repository;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysAuth;
import cn.spring.mvn.client.web.model.primarykey.SifSysAuthPk;

@Service("SifSysAuthRepository")
public interface SifSysAuthRepository extends Repository<SifSysAuth, SifSysAuthPk> {

}
