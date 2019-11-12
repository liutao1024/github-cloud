package cn.spring.mvn.core.credit.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.credit.entity.CoreCreditEntity;
import cn.spring.mvn.core.credit.entity.dao.CoreCreditEntityDao;
import cn.spring.mvn.core.credit.entity.service.CoreCreditEntityService;


@Service("CoreLoanEntityService")
public class CoreCreditEntityServiceImpl implements CoreCreditEntityService{
	@Resource
	private CoreCreditEntityDao dao;
	@Override
	public List<CoreCreditEntity> selectCoreLoanEntityList() {
		return dao.selectCoreLoanEntityList();
	}

}
