package cn.spring.mvn.note.web.entity.dao;

import java.util.List;

import cn.spring.mvn.note.web.entity.NoteBook;
import cn.spring.mvn.note.web.entity.User;

public interface AssociationDao {
	//单个对象查询
	public User findUser(String userId);

	// 多个对象(集合)关联映射
	public List<User> findAllUsers();

	// 单个对象关联映射
	public List<NoteBook> findAllBooks();
}
