package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysBatchTaskTimerExecuteResult;
import cn.spring.mvn.system.entity.service.SysBatchTaskTimerExecuteResultService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SysBatchTaskTimerExecuteResultService")
public class SysBatchTaskTimerExecuteResultServiceImpl extends HibernateServiceImpl<SysBatchTaskTimerExecuteResult> implements SysBatchTaskTimerExecuteResultService{

}
