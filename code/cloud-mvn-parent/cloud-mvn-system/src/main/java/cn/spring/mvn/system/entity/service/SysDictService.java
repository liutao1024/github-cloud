package cn.spring.mvn.system.entity.service;

import java.util.List;

import cn.spring.mvn.basic.hibernate.HibernateService;
import cn.spring.mvn.system.entity.SysDict;

public interface SysDictService extends HibernateService<SysDict>{
	public abstract List<SysDict> selectAllByDictType(String dictType);
}
