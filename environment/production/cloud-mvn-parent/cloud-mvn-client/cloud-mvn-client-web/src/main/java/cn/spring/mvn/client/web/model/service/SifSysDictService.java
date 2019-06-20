package cn.spring.mvn.client.web.model.service;

import java.util.List;

import cn.spring.mvn.client.web.model.SifSysDict;

public interface SifSysDictService {
	
	/***
	 * 根据字典类型获取所有字典
	 * @param dictType 字典类型
	 * @return 字典
	 */
	List<SifSysDict> getDictsByDictType(String dictType);
	
	/**
	 * 根据主键查询字典
	 * @param dictType 字典类型
	 * @param dictId 字典号
	 * @return 字典
	 */
	SifSysDict getDictById(String dictType,String dictId);
	
	/**
	 * 获取子字典
	 * @param dictType 父字典类型
	 * @param dictId 父字典号
	 * @return 字典
	 */
	List<SifSysDict> getChildDicts(String dictType,String dictId);
}
