package cn.spring.mvn.client.web.model.repository;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.repository.Repository;
import cn.spring.mvn.client.web.model.User;

@Service("UserRepository")
public interface UserRepository extends Repository<User, Serializable>{
	User findById(Integer id);
}
