package org.cloud.mvn.zstudy.javaVirtualMachine.classLoading;
/**
 * 非主动使用类字段演示
 */
public class NotInitialization {
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午9:20:46 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
//		Test001();
//		Test002();
//		Test003();
		Test004();
//		Test0024();
	}
	/**
	 * @Author LiuTao @Date 2020年9月17日 上午9:39:45 
	 * @Title: Test001 
	 * @Description: 被动使用类字段演示一:通过子类引用父类的静态字段,不会导致子类初始化
	 */
	public static void Test001(){
		System.out.println(SubClass.value);
	}
	/**
	 * @Author LiuTao @Date 2020年9月17日 上午9:43:59 
	 * @Title: Test002 
	 * @Description: 被动使用类字段演示二:通过数组定义来引用类, 不会触发此类的初始化
	 */
	public static void Test002(){
		SuperClass[] arr = new SuperClass[10];
		arr.hashCode();
	}
	/**
	 * @Author LiuTao @Date 2020年9月17日 上午9:53:43 
	 * @Title: Test003 
	 * @Description: 被动使用类字段演示三:常量在编译阶段会存入调用类的常量池中,本质上没有直接引用到定义常量的类,因此不会触发定义常量的类的初始化
	 */
	public static void Test003(){
		System.out.println(ConstClass.HELLOWORD);
	}
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午9:20:06 
	 * @Title: Test004 
	 * @Description: TODO(Describe)
	 */
	public static void Test004(){
		System.out.println(Sub.B);
	}
	/**
	 * @Author LiuTao @Date 2020年9月17日 上午9:41:05 
	 * @Title: Test002 
	 * @Description: TODO(Describe)
	 */
	public static void Test0024(){
		SubClass sb = new SubClass();
		
//		System.out.println(sb.str);
		sb.sayHello();
	}
}
class ConstClass{
	static{
		System.out.println("ConstClass init!");
	}
	public static final String HELLOWORD = "Hello Word!";//常量会进入引用类的常量池
}
class SuperClass {
	static {
		System.out.println("SuperClass init!");
	}
	public static int value = 123;
	public String str = "Super";
	
	public void sayHello(){
		System.out.println("Hello, I am Super!");
	}
}

class SubClass extends SuperClass {
	static {
		System.out.println("SubClass init!");
	}
	public static int value = 321;//
	public void sayHello(){
		System.out.println();
	}
	public void sayHello(String s){
		System.out.println("Hello, I am Super!");
	}
}
class Parent {
	public static int A = 1;
	static {
		A = 2;
//		System.out.println(i);//Cannot reference a field before it is defined
	}
}
class Sub extends Parent{
	public static int B = A;
}