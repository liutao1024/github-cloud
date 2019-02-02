package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysBatchTaskTimer;
import cn.spring.mvn.system.entity.service.SysBatchTaskTimerService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SysBatchTaskTimerService")
public class SysBatchTaskTimerServiceImpl extends HibernateServiceImpl<SysBatchTaskTimer> implements SysBatchTaskTimerService{

}
