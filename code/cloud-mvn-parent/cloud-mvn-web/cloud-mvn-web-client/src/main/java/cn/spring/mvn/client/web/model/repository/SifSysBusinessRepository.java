package cn.spring.mvn.client.web.model.repository;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysBusiness;
import cn.spring.mvn.client.web.model.primarykey.SifSysBusinessPk;

@Service("SifSysBusinessRepository")
public interface SifSysBusinessRepository extends Repository<SifSysBusiness, SifSysBusinessPk> {
	
}
