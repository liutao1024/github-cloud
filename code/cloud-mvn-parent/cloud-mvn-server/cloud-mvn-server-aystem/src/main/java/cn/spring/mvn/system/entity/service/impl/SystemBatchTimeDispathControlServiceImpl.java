package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SystemBatchTimeDispathControl;
import cn.spring.mvn.system.entity.service.SystemBatchTimeDispathControlService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SystemBatchTimeDispathControlService")
public class SystemBatchTimeDispathControlServiceImpl extends HibernateServiceImpl<SystemBatchTimeDispathControl> implements SystemBatchTimeDispathControlService{

}
