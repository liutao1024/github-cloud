package cn.spring.mvn.client.web.model.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysTeamMember;
import cn.spring.mvn.client.web.model.primarykey.SifSysTeamMemberPk;

@Service("SifSysTeamMemberRepository")
public interface SifSysTeamMemberRepository extends Repository<SifSysTeamMember, SifSysTeamMemberPk> {
	
	/**
	 * 根据模版查询实体
	 * @param registerCd
	 * @param teamCd
	 * @return 查询到的实体对象集合
	 */
	List<SifSysTeamMember> findByRegisterCdAndTeamCd(String registerCd, String teamCd);
	
}
