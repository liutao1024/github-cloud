package org.cloud.mvn.zstudy.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;

/**
 * @Author LiuTao @Date 2020年7月30日 下午2:37:26
 * @ClassName: ListTest 
 * @Description: TODO(Describe)
 */
public class ListTest {
	/**
	 * @Author LiuTao @Date 2020年7月30日 下午2:37:30 
	 * @Title: main 
	 */
	public static void main(String[] args) {
//		test001();
		listIteratorTest();
	}
	
	public static void test001(){
		Set<Integer> set = new HashSet<Integer>();
		set.add(12);
		set.add(8);
		set.add(-2);
		set.add(-7);
		for (Integer integer : set) {
			System.out.print(integer + "  ");
		}
		System.out.println();
		for (int i = 0; i < set.size(); i++) {
			System.out.print(set.getClass() + "  ");
		}
		System.out.println();
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(8);
		list.add(-2);
		list.add(-7);
		for (Integer integer : list) {
			System.out.print(integer + "  ");
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "  ");
		}
		
	} 
	/**
	 * @Author LiuTao @Date 2020年7月31日 上午9:51:50 
	 * @Title: listIteratorTest 
	 * @Description: TODO(Describe)
	 */
	public static void listIteratorTest(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(8);
		list.add(-2);
		list.add(-7);
		String[] books = {"Spring boot","Mybatis","Oracle"};
		List<String> bookList = new ArrayList<String>();
		for (int i = 0; i < books.length; i++) {
			bookList.add(books[i]);
		}
		ListIterator<String> lit = bookList.listIterator();
		while (lit.hasNext()) {
			System.out.println(lit.next());
			lit.add("---------分隔符-----------");
		}
		System.out.println("=========反向迭代==========");
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}
	
	public static void vectorTest(){
		Stack<String> stack = new Stack<String>();
		stack.push("Spring Boot");
		stack.push("Apache");
		stack.push("Orcale");
		System.out.println(stack);
		String x = stack.peek();
		System.out.println(x);
		System.out.println(stack);
		String y = stack.pop();
		System.out.println(y);
		System.out.println(stack);
	}
	
	
	public static void arrayListTest(){
		List<Object> list = new ArrayList<Object>();
		list.add(12);
	}
	/**
	 * @Author LiuTao @Date 2020年7月31日 下午4:18:41 
	 * @Title: arraysAsListTest 
	 * @Description: TODO(Describe)
	 */
	public static void arraysAsListTest(){
		List<String> list = Arrays.asList("Spring Cloud", "MyBatis", "Apache");
		System.out.println(list.getClass());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
