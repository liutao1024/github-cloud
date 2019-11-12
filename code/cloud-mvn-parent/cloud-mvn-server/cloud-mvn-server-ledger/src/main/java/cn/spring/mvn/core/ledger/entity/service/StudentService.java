package cn.spring.mvn.core.ledger.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.ledger.entity.Student;


public interface StudentService extends IBatisService<Student>{
	public List<Student> selectStudents();
}
