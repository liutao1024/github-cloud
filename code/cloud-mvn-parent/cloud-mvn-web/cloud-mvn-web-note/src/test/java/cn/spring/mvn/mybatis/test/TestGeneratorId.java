package cn.spring.mvn.mybatis.test;

import cn.spring.mvn.note.web.entity.Emp;
import cn.spring.mvn.note.web.entity.dao.EmpDao;

public class TestGeneratorId extends TestBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmpDao dao = getApplicationContext().getBean("empDao", EmpDao.class);
		Emp emp = new Emp();
		emp.setName("mybatis");
		emp.setAge(21);
		dao.save(emp);
		System.out.println("主键值为:" + emp.getId());
	}

}
