package org.cloud.mvn.spring.ioc;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 * Spring 学习网址: https://www.w3cschool.cn/wkspring/f8pc1hae.html
 * 1.Bean的	程序(应用)启动时,spring容器初始化时,读取bean配置文件,根据注册表实例化bean,bean实例放入spring容器,应用程序使用bean
 * 1.Bean的5个作用域:
 * 	 	作用域	         	描述
 * 		singleton		在spring IoC容器仅存在一个Bean实例,Bean以单例方式存在,默认值
 * 		prototype		每次从容器中调用Bean时,都返回一个新的实例,即每次调用getBean()时,相当于执行newXxxBean()
 * 		request			每次HTTP请求都会创建一个新的Bean,该作用域仅适用于WebApplicationContext环境
 * 		session			同一个HTTP Session共享一个Bean,不同Session使用不同的Bean,仅适用于WebApplicationContext环境
 * 		global-session	一般用于Portlet应用环境,该运用域仅适用于WebApplicationContext环境
 * 2.Bean的生命周期:	Bean的定义——>Bean的初始化——>Bean的使用——>Bean的销毁
 */
@SuppressWarnings({"deprecation", "resource"})
public class SpringIOCApp {
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午9:21:18 
	 * @Title: main 
	 * @Description: 主程序 
	 * @param args
	 */
	public static void main(String[] args) {
		InheritBean();
//		InitHelloWorld();
//		InitDestroyMethodBean();
//		PrototypeBean();
//		SingletonBean();
//		UseXmlBeanFactory();
//		SpringHelloWorld();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午11:10:20 
	 * @Title: InheritBean 
	 * @Description: Spring bean定义继承
	 */
	public static void InheritBean(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringIOCBeans.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.getMessage();
		objA.getMessage2();
		HelloChina objB = (HelloChina) context.getBean("helloChina");
		objB.getMessage();
		objB.getMessage2();
		objB.getMessage3();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午10:55:15 
	 * @Title: InitHelloWorld 
	 * @Description: Spring Bean的后置处理器
	 */
	public static void InitHelloWorld(){
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext("SpringIOCBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("initDestroyMethodHelloWorld");
		obj.getMessage();
		context.registerShutdownHook();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午10:50:19 
	 * @Title: InitDestroyMethodBean 
	 * @Description: 初始化和销毁的
	 */
	public static void InitDestroyMethodBean() {
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext("SpringIOCBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("initDestroyMethodHelloWorld");
		obj.getMessage();
		context.registerShutdownHook();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午10:26:06 
	 * @Title: PrototypeBean 
	 * @Description: Prototype是原型类型，它在我们创建容器的时候并没有实例化，而是当我们获取bean的时候才会去创建一个对象，而且我们每次获取到的对象都不是同一个对象
	 */
	public static void PrototypeBean(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringIOCBeans.xml");
		HelloWorld objA = (HelloWorld) context.getBean("prototypeHelloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();
		HelloWorld objB = (HelloWorld) context.getBean("prototypeHelloWorld");
		objB.getMessage();
		
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午10:19:46 
	 * @Title: SingletonBean 
	 * @Description: Singleton是单例类型，就是在创建起容器时就同时自动创建了一个bean的对象，不管你是否使用，他都存在了，每次获取到的对象都是同一个对象。注意，Singleton作用域是Spring中的缺省作用域
	 */
	public static void SingletonBean (){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringIOCBeans.xml");
		HelloWorld objA = (HelloWorld) context.getBean("singletonHelloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();
		HelloWorld objB = (HelloWorld) context.getBean("singletonHelloWorld");
		objB.getMessage();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午9:27:51 
	 * @Title: UseXmlBeanFactory 
	 * @Description: TODO(Describe)
	 */
	public static void UseXmlBeanFactory(){
		/**
		 * 	第一步利用框架提供的 XmlBeanFactory() API 去生成工厂 bean 以及利用 ClassPathResource() API 
		 * 		去加载在路径 CLASSPATH下可用的 bean 配置文件.XmlBeanFactory() API 负责创建并初始化所有的对象,
		 * 		即在配置文件中提到的 bean.
		 * 	第二步利用第一步生成的 bean 工厂对象的 getBean() 方法得到所需要的 bean. 
		 * 		这个方法通过配置文件中的 bean ID 来返回一个真正的对象,该对象最后可以用于实际的对象.一旦得到这个对象,
		 * 		你就可以利用这个对象来调用任何方法
		 */
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("SpringIOCBeans.xml"));
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.getMessage();
	}
	/**
	 * @Author LiuTao @Date 2020年10月22日 上午9:22:32 
	 * @Title: SpringHelloWorld 
	 * @Description: HelloWorld
	 */
	public static void SpringHelloWorld() {
		/**
		 * 该容器从 XML 文件中加载已被定义的 bean.在这里,你不需要提供 XML 文件的完整路径,
		 * 只需正确配置 CLASSPATH 环境变量即可,因为,容器会从 CLASSPATH 中搜索 bean 配置文件
		 */
		ApplicationContext classPathContext = new ClassPathXmlApplicationContext("SpringIOCBeans.xml");
		/**
		 * 该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean
		 */
//		ApplicationContext webContext = new WebXmlApplicationContext("SpringBeans.xml");
		/**
		 * 该容器从 XML 文件中加载已被定义的 bean.在这里,你需要提供给构造器 XML 文件的完整路径
		 */
		ApplicationContext fileSystemContext = new FileSystemXmlApplicationContext("E:/Tortoise/GitHub/github-cloud/code/cloud-mvn-parent/cloud-mvn-zzspring/src/main/resources/SpringIOCBeans.xml");
		HelloWorld cobj = (HelloWorld) classPathContext.getBean("helloWorld");
		cobj.getMessage();
		HelloWorld fobj = (HelloWorld) fileSystemContext.getBean("helloWorld");
		fobj.getMessage();
	}
}
