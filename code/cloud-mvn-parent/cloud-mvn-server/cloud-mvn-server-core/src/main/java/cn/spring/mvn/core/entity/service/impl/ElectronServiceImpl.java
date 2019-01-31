package cn.spring.mvn.core.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.entity.Electron;
import cn.spring.mvn.core.entity.service.ElectronService;

@Repository("ElectronService")
public class ElectronServiceImpl extends IBatisServiceImpl<Electron> implements ElectronService{

	@Override
	public List<Electron> selectAll() {
		return null;
	}
	
}