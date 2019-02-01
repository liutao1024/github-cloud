package cn.spring.mvn.client.com.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.com.model.ApSysServs;

@Service("ApSysServsRepository")
public interface ApSysServsRepository extends Repository<ApSysServs, String>{

	@Query(value="select a from ApSysServs a where a.serviceCd = ?1 ")
	ApSysServs findOne(String serviceCd);

}
