package org.cloud.mvn.zstudy.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JavaTest {
	public static void main(String[] args) {
//		Test001();	
//		Test002();	
		Test003();	
	}
	public static void Test001() {
		Collection<String> books = new HashSet<String>();
		books.add("深入理解JVM原理");
		books.add("Java数据结构与算法");
		books.add("Mysql从入门到精通");
		System.out.println(books);
		Iterator<String> it = books.iterator();
		while (it.hasNext()) {
			String book = it.next();
			if(book.equals("Java数据结构与算法")){
//				it.remove();
				books.remove(book);
			}
			book = "Linux-运维入门到高级全套系列";
		}
		System.out.println(books);
		for (String string : books) {
			books.remove(string);
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(12);
		list.add(12);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer i = iterator.next();
			if(i == 12){
				list.remove(i);
			}
		}
	}
	/**
	 * @Author LiuTao @Date 2020年7月21日 下午2:33:10 
	 * @Title: Test002 
	 * @Description: 有没有i+1<i的数;计算0/0,0.0/0.0,0/0.0;
	 */
	public static void Test002() {
		int i = Integer.MAX_VALUE;
		int j = i + 1;
		System.out.println(j < i);
		int x = Integer.MAX_VALUE;
		int y = Integer.MIN_VALUE;
		System.out.println(x);
		System.out.println(y);
		
		System.out.println(0.0/0.0);
		System.out.println(0/0.0);
		System.out.println(0/0);
	}
	/**
	 * @Author LiuTao @Date 2020年7月22日 下午2:27:19 
	 * @Title: Test003 
	 * @Description: TODO(Describe)
	 */
	public static void Test003() {
		Set<String> set = new HashSet<String>();
		set.add("How are you?");
		set.add("I am fine.");
		set.add("And you?");
		set.add("me too.");
		String a = new String("How are yuo?");
		String b = new String("How are yuo?");
		System.out.println(a.equals("How are you?"));
		System.out.println(a == b);
		System.out.println(a.equals(b));
		set.add(a);
		set.add(b);
		System.out.println(set);
	}
}
