package org.cloud.mvn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * Spring 学习网址: https://www.w3cschool.cn/wkspring/f8pc1hae.html
 */
@SuppressWarnings("resource")
public class SpringApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
}
