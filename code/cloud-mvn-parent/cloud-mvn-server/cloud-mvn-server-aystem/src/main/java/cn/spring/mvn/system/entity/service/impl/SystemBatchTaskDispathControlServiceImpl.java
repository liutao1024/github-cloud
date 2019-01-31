package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SystemBatchTaskDispathControl;
import cn.spring.mvn.system.entity.service.SystemBatchTaskDispathControlService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SystemBatchTaskDispathControlService")
public class SystemBatchTaskDispathControlServiceImpl extends HibernateServiceImpl<SystemBatchTaskDispathControl> implements SystemBatchTaskDispathControlService{

}
