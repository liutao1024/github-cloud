package org.cloud.mvn.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author LiuTao @Date 2020年10月22日 下午5:30:56
 * @ClassName: SpringAnnotationApp 
 * @Description: Spring 基于注解的配置
 * https://www.w3cschool.cn/wkspring/43851h9t.html
 * 				注解 & 描述
 * 1	@Required 注解应用于 bean 属性的 setter 方法.
 * 2	@Autowired 注解可以应用到 bean 属性的 setter 方法,非 setter 方法,构造函数和属性.
 * 3	@Qualifier 通过指定确切的将被连线的 bean,@Autowired 和 @Qualifier 注解可以用来删除混乱.
 * 4	JSR-250 Annotations Spring 支持 JSR-250 的基础的注解,其中包括了 @Resource,@PostConstruct 和 @PreDestroy 注解.
 */
@SuppressWarnings("resource")
public class SpringAnnotationApp {
	/**
	 * @Author LiuTao @Date 2020年10月23日 上午10:32:04 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigurationAndBean();
//		AnnotationQualifier();
//		AnnotationRequired();
	}

	public static void AnnotationConfigurationAndBean(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		Student student = context.getBean(Student.class);
		student.setName("Davida");
		student.getName();
	}
	/**
	 * @Author LiuTao @Date 2020年10月23日 上午10:30:19 
	 * @Title: AnnotationQualifier 
	 * @Description: 可能会有这样一种情况，当你创建多个具有相同类型的 bean 时，
	 * 				并且想要用一个属性只为它们其中的一个进行装配，在这种情况下，
	 * 				你可以使用 @Qualifier 注释和 @Autowired 注释通过指定哪一个真正的 bean 将会被装配来消除混乱
	 */
	public static void AnnotationQualifier() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringAnnotationBeans.xml");
		Profile profile = (Profile) context.getBean("qualifier");
		profile.printName();
		profile.printAge();
	}
	/**
	 * @Author LiuTao @Date 2020年10月23日 上午10:30:19 
	 * @Title: AnnotationRequired 
	 * @Description: TODO(Describe)
	 */
	public static void AnnotationRequired() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringAnnotationBeans.xml");
		Student student = (Student) context.getBean("requiredStudent");
		System.out.println("Name : " + student.getName());
		System.out.println("Age : " + student.getAge());
	}
}
