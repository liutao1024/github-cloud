package cn.spring.mvn.system.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SystemTransaction;
import cn.spring.mvn.system.entity.service.SystemTransactionService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;
import cn.spring.mvn.basic.util.BasicUtil;

@Service("SystemTransactionService")
public class SystemTransactionServiceImpl extends HibernateServiceImpl<SystemTransaction> implements SystemTransactionService{

	@Override
	public SystemTransaction selectOne(String prcscd, String trantp) {
		SystemTransaction transaction  = null;
		String hqlStr = "from SystemTransaction where transactionCode = '" + prcscd + "' ";
		if(BasicUtil.isNotNull(trantp)){
			hqlStr = hqlStr + "and transactionType = '" + trantp + "'";
		}
		List<SystemTransaction> list = this.findAllByHql(hqlStr);
		if(BasicUtil.isNotNull(list) && list.size() > 0){
			transaction = list.get(0);
		}
		return transaction;
	}

}
