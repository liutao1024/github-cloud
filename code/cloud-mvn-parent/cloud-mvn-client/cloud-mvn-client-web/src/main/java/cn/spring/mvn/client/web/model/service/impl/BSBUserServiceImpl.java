package cn.spring.mvn.client.web.model.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.client.web.model.BSBUser;
import cn.spring.mvn.client.web.model.service.BSBUserService;

@Service("BSBUserService")
public class BSBUserServiceImpl implements BSBUserService {
	@Override
	public BSBUser login(BSBUser user) {
		System.out.println(user.getPasswd());
		// Map<String, Object> recvMsg=service.callSerive("socket",
		// "{'userid':'"+user.getUserid()+"','passwd':'"+user.getPasswd()+"','pswdfg':'"+user.getPswdfg()+"'}");
		return user;
	}

}
