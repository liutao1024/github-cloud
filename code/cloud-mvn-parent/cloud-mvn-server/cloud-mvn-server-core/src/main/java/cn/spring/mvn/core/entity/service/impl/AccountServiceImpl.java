package cn.spring.mvn.core.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.entity.Account;
import cn.spring.mvn.core.entity.service.AccountService;

@Repository("AccountService")
public class AccountServiceImpl extends IBatisServiceImpl<Account> implements AccountService{

	@Override
	public List<Account> selectAll() {
		return null;
	}
	
}