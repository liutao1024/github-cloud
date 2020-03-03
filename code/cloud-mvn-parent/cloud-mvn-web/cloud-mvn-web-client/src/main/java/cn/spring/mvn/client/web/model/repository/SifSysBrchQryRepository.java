package cn.spring.mvn.client.web.model.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysBrchQry;
import cn.spring.mvn.client.web.model.primarykey.SifSysBrchQryPk;

@Service("SifSysBrchQryRepository")
public interface SifSysBrchQryRepository extends Repository<SifSysBrchQry, SifSysBrchQryPk> {
	
	/**
	 * 根据注册机构号和机构号查询
	 * @param registerCd 注册机构号
	 * @param branchCd	机构号
	 * @return 查询到的实体对象集合
	 */
	List<SifSysBrchQry> findByRegisterCdAndBranchCd(String registerCd, String branchCd);
}
