package cn.spring.mvn.client.web.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.spring.mvn.client.web.model.User;
import cn.spring.mvn.client.web.model.repository.UserRepository;
import cn.spring.mvn.client.web.model.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public User save(String name) {
		return userRepository.save(new User(name));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
//	public List<User>

}
