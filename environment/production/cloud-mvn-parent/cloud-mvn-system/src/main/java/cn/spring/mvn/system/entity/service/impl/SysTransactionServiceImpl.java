package cn.spring.mvn.system.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysTransaction;
import cn.spring.mvn.system.entity.service.SysTransactionService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;
import cn.spring.mvn.basic.util.BasicUtil;

@Service("SysTransactionService")
public class SysTransactionServiceImpl extends HibernateServiceImpl<SysTransaction> implements SysTransactionService{

	@Override
	public SysTransaction selectOne(String prcscd, String trantp) {
		SysTransaction transaction  = null;
		String hqlStr = "from SysTransaction where transactionCode = '" + prcscd + "' ";
		if(BasicUtil.isNotNull(trantp)){
			hqlStr = hqlStr + "and transactionType = '" + trantp + "'";
		}
		List<SysTransaction> list = this.findAllByHql(hqlStr);
		if(BasicUtil.isNotNull(list) && list.size() > 0){
			transaction = list.get(0);
		}
		return transaction;
	}

}
