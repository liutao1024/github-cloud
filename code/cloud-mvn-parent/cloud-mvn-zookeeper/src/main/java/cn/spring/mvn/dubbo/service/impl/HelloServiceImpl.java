package cn.spring.mvn.dubbo.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvn.dubbo.service.HelloService;

@Service("HelloServiceImpl")
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello(String name) {
		return "Hello," + name + "!";
	}

}
