package cn.spring.mvn.core.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.entity.Organization;

public interface OrganizationService extends IBatisService<Organization>{
	public List<Organization> selectAll();
}
