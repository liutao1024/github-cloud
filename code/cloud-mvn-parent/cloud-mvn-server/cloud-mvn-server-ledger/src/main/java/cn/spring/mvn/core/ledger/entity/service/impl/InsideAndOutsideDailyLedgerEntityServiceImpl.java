package cn.spring.mvn.core.ledger.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.core.ledger.entity.InsideAndOutsideDailyLedgerEntity;
import cn.spring.mvn.core.ledger.entity.dao.InsideAndOutsideDailyLedgerEntityDao;
import cn.spring.mvn.core.ledger.entity.service.InsideAndOutsideDailyLedgerEntityService;


@Service("CoreLoanEntityService")
public class InsideAndOutsideDailyLedgerEntityServiceImpl implements InsideAndOutsideDailyLedgerEntityService{
	@Resource
	private InsideAndOutsideDailyLedgerEntityDao dao;
	@Override
	public List<InsideAndOutsideDailyLedgerEntity> selectCoreLoanEntityList() {
		return dao.selectCoreLoanEntityList();
	}

}
