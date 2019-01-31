package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SystemParam;
import cn.spring.mvn.system.entity.service.SystemParamService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemParamService")
public class SystemParamServiceImpl extends HibernatServiceImpl<SystemParam>
		implements SystemParamService {

}
