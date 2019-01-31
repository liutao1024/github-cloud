package cn.spring.mvn.web.entity.service;

import java.util.List;

import cn.spring.mvn.basic.hibernate.HibernateService;
import cn.spring.mvn.web.entity.SysDict;

public interface SysDictService extends HibernateService<SysDict>{
	public abstract List<SysDict> selectAllByDictType(String dictType);
}
