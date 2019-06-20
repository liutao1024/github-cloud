package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysBatchTaskControl;
import cn.spring.mvn.system.entity.service.SysBatchTaskControlService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SysBatchTaskControlService")
public class SysBatchTaskControlServiceImpl extends HibernateServiceImpl<SysBatchTaskControl> implements SysBatchTaskControlService{

}
