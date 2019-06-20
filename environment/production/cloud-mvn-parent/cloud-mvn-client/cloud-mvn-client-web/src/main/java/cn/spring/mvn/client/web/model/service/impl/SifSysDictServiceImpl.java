package cn.spring.mvn.client.web.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.spring.mvn.client.web.model.SifSysDict;
import cn.spring.mvn.client.web.model.repository.SifSysDictRepository;
import cn.spring.mvn.client.web.model.service.SifSysDictService;

@Service("SifSysDictService")
@Transactional(readOnly = true)
public class SifSysDictServiceImpl implements SifSysDictService {

	@Autowired
	private SifSysDictRepository sifSysDictRepository;// 注入Repository

	/***
	 * 根据字典类型获取所有字典
	 * 
	 * @param dictType
	 *            字典类型
	 * @return 字典
	 */
	@Cacheable(value="dictCache", condition="#dictType!=null",key="#dictType.toString()")
	public List<SifSysDict> getDictsByDictType(String dictType) {
		return sifSysDictRepository.findByDictType(dictType);
	}

	/**
	 * 根据主键查询字典
	 * 
	 * @param dictType
	 *            字典类型
	 * @param dictId
	 *            字典号
	 * @return 字典
	 */
	public SifSysDict getDictById(String dictType, String dictId) {
		return sifSysDictRepository.findByDictTypeAndDictId(dictType, dictId);
	}

	/**
	 * 获取子字典
	 * 
	 * @param dictType
	 *            父字典类型
	 * @param dictId
	 *            父字典号
	 * @return 字典
	 */
	public List<SifSysDict> getChildDicts(String dictType, String dictId) {
		return sifSysDictRepository.findByParentDictTypeAndParentDictId(dictType, dictId);
	}
}
