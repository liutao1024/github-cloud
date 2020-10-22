package org.cloud.mvn.spring.dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class SpringDependencyInjectionApp {
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午11:35:16 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringZhuRuJiHe();
//		SpringZhuRuNeiBuBeans();
//		JiYuSheZhiHanShuDeYiLaiZhuRu();
//		JiYuGouZhaoHanShuDeYiLaiZhuRu();
	}

	/**
	 * @Author LiuTao @Date 2020年10月22日 下午3:15:51 
	 * @Title: SpringZhuRuJiHe 
	 * @Description: Spring注入集合
	 */
	public static void SpringZhuRuJiHe() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringDependencyInjectionBeans.xml");
		JavaCollection jc = (JavaCollection) context.getBean("javaCollection");
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 下午3:14:42 
	 * @Title: SpringZhuRuNeiBuBeans 
	 * @Description: Spring 注入内部 Beans
	 */
	public static void SpringZhuRuNeiBuBeans(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringDependencyInjectionBeans.xml");
		TextEditor te = (TextEditor) context.getBean("textEditorOutter");
		te.spellCheck();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午11:34:13 
	 * @Title: JiYuSheZhiHanShuDeYiLaiZhuRu 
	 * @Description: Spring 基于设值函数的依赖注入
	 */
	public static void JiYuSheZhiHanShuDeYiLaiZhuRu(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringDependencyInjectionBeans.xml");
		TextEditor te = (TextEditor) context.getBean("propertyTextEditor");
		te.spellCheck();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午11:34:13 
	 * @Title: JiYuGouZhaoHanShuDeYiLaiZhuRu 
	 * @Description: Spring 基于构造函数的依赖注入
	 */
	public static void JiYuGouZhaoHanShuDeYiLaiZhuRu(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringDependencyInjectionBeans.xml");
		TextEditor te = (TextEditor) context.getBean("constructorTextEditor");
		te.spellCheck();
	}
}
