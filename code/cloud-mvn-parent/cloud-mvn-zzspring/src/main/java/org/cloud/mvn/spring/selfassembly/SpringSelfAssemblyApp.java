package org.cloud.mvn.spring.selfassembly;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class SpringSelfAssemblyApp {
	/**
	 * @Author LiuTao @Date 2020年10月22日 下午4:26:20 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		YouGouZhaoHanShuZiDongZhuangZai();
//		ZiDongZhuangPeiByType();
//		ZiDongZhuangPeiByName();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 下午4:25:54 
	 * @Title: YouGouZhaoHanShuZiDongZhuangZai 
	 * @Description: Spring 有构造函数自动装载
	 */
	public static void YouGouZhaoHanShuZiDongZhuangZai(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringSelfAssemblyBeans.xml");
		TextEditor te = (TextEditor) context.getBean("byConstructorTextEditor");
		te.spellCheck();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 下午4:25:54 
	 * @Title: ZiDongZhuangPeiByName 
	 * @Description: 自动装配ByName
	 */
	public static void ZiDongZhuangPeiByType(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringSelfAssemblyBeans.xml");
		TextEditor te = (TextEditor) context.getBean("byTypeTextEditor");
		te.spellCheck();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 下午4:25:54 
	 * @Title: ZiDongZhuangPeiByName 
	 * @Description: 自动装配ByName
	 */
	public static void ZiDongZhuangPeiByName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringSelfAssemblyBeans.xml");
		TextEditor te = (TextEditor) context.getBean("byNameTextEditor");
		te.spellCheck();
	}
}
