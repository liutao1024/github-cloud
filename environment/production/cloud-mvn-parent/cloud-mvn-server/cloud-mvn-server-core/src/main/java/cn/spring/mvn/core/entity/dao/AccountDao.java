package cn.spring.mvn.core.entity.dao;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisDao;
import cn.spring.mvn.core.entity.Account;

public interface AccountDao extends IBatisDao<Account>{
	public List<Account> selectAll();
}
