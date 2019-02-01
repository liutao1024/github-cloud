package cn.spring.mvn.client.web.model.service;

import java.util.List;

import cn.spring.mvn.client.web.model.User;

public interface UserService {
	User findById(Integer id);
    User save(String name);
    List<User> findAll();
}
