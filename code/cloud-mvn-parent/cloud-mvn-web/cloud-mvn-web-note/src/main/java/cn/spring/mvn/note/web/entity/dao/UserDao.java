package cn.spring.mvn.note.web.entity.dao;

import cn.spring.mvn.note.web.entity.User;

public interface UserDao {
    public abstract User findByName(String username);
    public void save(User user);
}
