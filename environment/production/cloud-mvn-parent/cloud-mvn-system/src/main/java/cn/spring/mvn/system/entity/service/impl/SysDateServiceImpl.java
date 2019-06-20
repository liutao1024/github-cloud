package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysDate;
import cn.spring.mvn.system.entity.service.SysDateService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SysDateService")
public class SysDateServiceImpl extends HibernateServiceImpl<SysDate> implements SysDateService{

}
