package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SysParam;
import cn.spring.mvn.system.entity.service.SysParamService;
import cn.spring.mvn.basic.hibernate.HibernateServiceImpl;

@Service("SysParamService")
public class SysParamServiceImpl extends HibernateServiceImpl<SysParam> implements SysParamService {

}
