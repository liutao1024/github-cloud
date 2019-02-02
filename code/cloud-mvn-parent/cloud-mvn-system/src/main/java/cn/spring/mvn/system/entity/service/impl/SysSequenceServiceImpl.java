package cn.spring.mvn.system.entity.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysSequence;
import cn.spring.mvn.system.entity.service.SysSequenceService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;
import cn.spring.mvn.basic.util.BasicUtil;

@Service("SysSequenceService")
public class SysSequenceServiceImpl extends HibernateServiceImpl<SysSequence> implements SysSequenceService{

	@Override
	public SysSequence selectOne(String sequenceType) {
		SysSequence sequence  = null;
		String hqlStr = "from SysSequence where sequencetype = '" + sequenceType + "'";
		List<SysSequence> list = this.findAllByHql(hqlStr);
		if(BasicUtil.isNotNull(list) && list.size() > 0){
			sequence = list.get(0);
		}
		return sequence;
	}

}
