package cn.spring.mvn.system.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SystemSequence;
import cn.spring.mvn.system.entity.service.SystemSequenceService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;
import cn.spring.mvn.basic.util.BasicUtil;

@Service("SystemSequenceService")
public class SystemSequenceServiceImpl extends HibernateServiceImpl<SystemSequence> implements SystemSequenceService{

	@Override
	public SystemSequence selectOne(String sequenceType) {
		SystemSequence sequence  = null;
		String hqlStr = "from SystemSequence where sequencetype = '" + sequenceType + "'";
		List<SystemSequence> list = this.findAllByHql(hqlStr);
		if(BasicUtil.isNotNull(list) && list.size() > 0){
			sequence = list.get(0);
		}
		return sequence;
	}

}
