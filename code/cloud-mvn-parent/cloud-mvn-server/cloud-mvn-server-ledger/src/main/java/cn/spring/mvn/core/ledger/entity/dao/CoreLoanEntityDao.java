package cn.spring.mvn.core.ledger.entity.dao;

import java.util.List;

import cn.spring.mvn.core.ledger.entity.CoreLoanEntity;

public interface CoreLoanEntityDao {
	public List<CoreLoanEntity> selectCoreLoanEntityList();
}
