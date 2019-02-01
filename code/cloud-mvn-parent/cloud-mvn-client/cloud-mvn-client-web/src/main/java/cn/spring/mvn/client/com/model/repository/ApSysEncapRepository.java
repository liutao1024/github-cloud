package cn.spring.mvn.client.com.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.com.model.ApSysEncap;

@Service("ApSysEncapRepository")
public interface ApSysEncapRepository extends Repository<ApSysEncap, String>{
	
	@Query(value="select a from ApSysEncap a where a.encapCd = ?1 ")
	ApSysEncap findOne(String encapCd);

}
