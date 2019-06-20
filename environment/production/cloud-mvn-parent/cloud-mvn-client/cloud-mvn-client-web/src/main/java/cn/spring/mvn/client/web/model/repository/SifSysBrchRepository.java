package cn.spring.mvn.client.web.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysBrch;
import cn.spring.mvn.client.web.model.primarykey.SifSysBrchPk;

@Service("SifSysBrchRepository")
public interface SifSysBrchRepository extends Repository<SifSysBrch, SifSysBrchPk> {
	
	/**
	 * 查询父级机构号为空的机构
	 * @param registerCd
	 * @return 查询到的实体对象集合
	 */
	@Query(value="select s from SifSysBrch s where s.registerCd = ?1 and parentBranchCd is null")
	List<SifSysBrch> findByParentBranchIsNull(String registerCd);
	
	/**
	 * 根据父级机构号查询子级机构
	 * @param registerCd
	 * @param parentBranchCd
	 * @return 查询到的实体对象集合
	 */
	List<SifSysBrch> findByRegisterCdAndParentBranchCd(String registerCd, String parentBranchCd);
	
	/**
	 * 统计当前机构子级机构数量
	 * @param registerCd
	 * @param branchCd
	 * @return 查询到的记录条数
	 */
	int countByRegisterCdAndParentBranchCd(String registerCd, String parentBranchCd);
	
}
