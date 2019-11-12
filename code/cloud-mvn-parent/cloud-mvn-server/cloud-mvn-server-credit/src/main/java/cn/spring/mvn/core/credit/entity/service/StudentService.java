package cn.spring.mvn.core.credit.entity.service;

import java.util.List;

import cn.spring.mvn.basic.ibatis.IBatisService;
import cn.spring.mvn.core.credit.entity.Student;


public interface StudentService extends IBatisService<Student>{
	public List<Student> selectStudents();
}
