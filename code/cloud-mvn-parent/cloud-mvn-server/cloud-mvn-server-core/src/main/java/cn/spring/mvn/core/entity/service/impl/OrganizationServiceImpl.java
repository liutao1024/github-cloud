package cn.spring.mvn.core.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.entity.Organization;
import cn.spring.mvn.core.entity.dao.OrganizationDao;
import cn.spring.mvn.core.entity.service.OrganizationService;

@Service("OrganizationService")
public class OrganizationServiceImpl extends IBatisServiceImpl<Organization> implements OrganizationService {
	@Resource
	private OrganizationDao dao;

	@Override
	public List<Organization> selectAll() {
		return dao.selectAll();
	}
	

}
