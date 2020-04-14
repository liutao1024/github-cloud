package cn.spring.mvn.mybatis.test;

import cn.spring.mvn.note.web.entity.User;
import cn.spring.mvn.note.web.entity.dao.UserDao;

public class TestUserDao extends TestBase {
	public static void main(String[] args) {
		UserDao userDao = getApplicationContext().getBean("userDao", UserDao.class);
		User user = userDao.findByName("demo2021");
		System.out.println("-----------");
		if (user == null) {
			System.out.println("用户名不正确");
		} else {
			System.out.println("1."+user.getCn_user_name());
			System.out.println("2."+user.getCn_user_id());
			System.out.println("3."+user.getCn_user_password());
		}
	}
}
