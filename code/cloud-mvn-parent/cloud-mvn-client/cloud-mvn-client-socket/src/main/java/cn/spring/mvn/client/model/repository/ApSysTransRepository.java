package cn.spring.mvn.client.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.model.ApSysTrans;

@Service("ApSysTransRepository")
public interface ApSysTransRepository extends Repository<ApSysTrans, String>{

	@Query(value="select a from ApSysTrans a where a.transCd = ?1 ")
	ApSysTrans findOne(String transCd);

}
