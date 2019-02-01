package cn.spring.mvn.client.web.model.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysPara;

@Service("SifSysParaRepository")
public interface SifSysParaRepository extends Repository<SifSysPara, String> {
	
	/**
	 * 根据registerCd获取该注册号的全局控制信息
	 * @param registerCd
	 * @return 全局控制信息
	 */
	public SifSysPara findByRegisterCd(String registerCd);
	
	/**
	 * 根据注册机构号，切换对应系统的日期到下一日期
	 * @param registerCd
	 */
	@Modifying
	@Query(value = "update SifSysPara para set para.lastSysDt = :lastSysDt,para.sysDt = :sysDt where para.registerCd = :registerCd")
	public int switchSysDate(@Param("registerCd")String registerCd, @Param("lastSysDt")Date lastSysDt, @Param("sysDt")Date sysDt);
	
}
