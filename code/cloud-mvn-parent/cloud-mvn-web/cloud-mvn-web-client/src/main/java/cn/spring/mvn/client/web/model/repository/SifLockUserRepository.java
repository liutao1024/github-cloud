package cn.spring.mvn.client.web.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifLockUser;

@Service("SifLockUserRepository")
public interface SifLockUserRepository extends Repository<SifLockUser, String> {

	@Query(value = "from SifLockUser a where a.userid = ?1")
	SifLockUser getSifLockUser(String userid);
}
