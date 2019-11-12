package cn.spring.mvn.core.credit.entity.dao;

import java.util.List;

import cn.spring.mvn.core.credit.entity.CoreLoanEntity;

public interface CoreLoanEntityDao {
	public List<CoreLoanEntity> selectCoreLoanEntityList();
}
