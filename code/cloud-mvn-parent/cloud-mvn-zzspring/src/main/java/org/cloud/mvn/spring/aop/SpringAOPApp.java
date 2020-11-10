package org.cloud.mvn.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @Author LiuTao @Date 2020年11月2日 上午11:09:53
 * @ClassName: SpringAOPApp 
 * @Description: TODO(Describe)
 * https://www.w3cschool.cn/wkspring/omps1mm6.html
 */
@SuppressWarnings("resource")
public class SpringAOPApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringAOPBeans.xml");
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		student.printThrowException();
	}
}
