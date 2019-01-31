package cn.spring.mvn.system.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.system.entity.SystemBatchTaskDispathControl;
import cn.spring.mvn.system.entity.service.SystemBatchTaskDispathControlService;
import cn.spring.mvn.basic.hibernat.HibernatServiceImpl;

@Service("SystemBatchTaskDispathControlService")
public class SystemBatchTaskDispathControlServiceImpl extends HibernatServiceImpl<SystemBatchTaskDispathControl> implements SystemBatchTaskDispathControlService{

}
