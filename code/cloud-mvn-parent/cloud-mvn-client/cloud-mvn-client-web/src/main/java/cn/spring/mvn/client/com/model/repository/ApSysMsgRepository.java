package cn.spring.mvn.client.com.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.com.model.ApSysMsg;

@Service("ApSysMsgRepository")
public interface ApSysMsgRepository extends Repository<ApSysMsg, String>{
	@Query(value="select a from ApSysMsg a where a.msgCd = ?1 ")
	ApSysMsg findOne(String msgCd);

}
