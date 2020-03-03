package cn.spring.mvn.client.web.model.repository;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysTeam;
import cn.spring.mvn.client.web.model.primarykey.SifSysTeamPk;

@Service("SifSysTeamRepository")
public interface SifSysTeamRepository extends Repository<SifSysTeam, SifSysTeamPk> {
	
}
