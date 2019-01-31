package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SystemBatchTimeTaskDispathResult;
import cn.spring.mvn.system.entity.service.SystemBatchTimeTaskDispathResultService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SystemBatchTimeTaskDispathResultService")
public class SystemBatchTimeTaskDispathResultServiceImpl extends HibernateServiceImpl<SystemBatchTimeTaskDispathResult> implements SystemBatchTimeTaskDispathResultService{

}
