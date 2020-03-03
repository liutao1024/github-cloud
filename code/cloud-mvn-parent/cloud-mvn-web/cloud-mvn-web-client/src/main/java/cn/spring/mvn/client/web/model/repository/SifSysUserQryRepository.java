package cn.spring.mvn.client.web.model.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysUserQry;
import cn.spring.mvn.client.web.model.primarykey.SifSysUserQryPk;

@Service("SifSysUserQryRepository")
public interface SifSysUserQryRepository extends Repository<SifSysUserQry, SifSysUserQryPk>{
	
	/**
	 * 根据注册机构号和操作员号查询
	 * @param registerCd 注册机构号
	 * @param userCd	操作员号
	 * @return 查询到的实体对象集合
	 */
	List<SifSysUserQry> findByRegisterCdAndUserCd(String registerCd, String userCd);
}
