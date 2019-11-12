package cn.spring.mvn.core.ledger.entity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.mvn.basic.ibatis.IBatisServiceImpl;
import cn.spring.mvn.core.ledger.entity.Student;
import cn.spring.mvn.core.ledger.entity.dao.StudentDao;
import cn.spring.mvn.core.ledger.entity.service.StudentService;


@Service("StudentService")
public class StudentServiceImpl extends IBatisServiceImpl<Student> implements StudentService{
	@Resource
	private StudentDao dao;
	@Override
	public List<Student> selectStudents() {
		return dao.selectAll();
	}

}
