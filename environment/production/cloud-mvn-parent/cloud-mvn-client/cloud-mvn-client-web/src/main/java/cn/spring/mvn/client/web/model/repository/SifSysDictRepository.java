package cn.spring.mvn.client.web.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.SifSysDict;

@Service("SifSysDictRepository")
public interface SifSysDictRepository extends Repository<SifSysDict, String> {

	@Query(value = "select a from SifSysDict a where a.dictType = ?1 and a.status = 'Y' order by a.sortNo ")
	List<SifSysDict> findByDictType(String dictType);

	SifSysDict findByDictTypeAndDictId(String dictType, String dictId);

	@Query(value = "select a from SifSysDict a where a.parentDictType = ?1 and a.parentDictId = ?2 and a.status = 'Y' order by a.sortNo ")
	List<SifSysDict> findByParentDictTypeAndParentDictId(String parentDictType, String parentDictId);
}
