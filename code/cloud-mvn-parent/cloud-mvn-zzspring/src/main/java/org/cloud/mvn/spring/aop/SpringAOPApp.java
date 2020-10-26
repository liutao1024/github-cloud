package org.cloud.mvn.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class SpringAOPApp {
	public static void main(String[] args) {
	      ApplicationContext context = 
	             new ClassPathXmlApplicationContext("SpringAOPBeans.xml");
	      Student student = (Student) context.getBean("student");
	      student.getName();
	      student.getAge();      
	      student.printThrowException();
	   }
}
