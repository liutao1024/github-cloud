package cn.spring.mvn.core.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.entity.Electron;

public interface ElectronService extends IBatisService<Electron>{
	public List<Electron> selectAll();
}