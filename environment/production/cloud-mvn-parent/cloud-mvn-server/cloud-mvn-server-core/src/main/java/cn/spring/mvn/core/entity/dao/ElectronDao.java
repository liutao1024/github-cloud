package cn.spring.mvn.core.entity.dao;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.entity.Electron;

public interface ElectronDao extends IBatisDao<Electron>{
	public List<Electron> selectAll();
}
