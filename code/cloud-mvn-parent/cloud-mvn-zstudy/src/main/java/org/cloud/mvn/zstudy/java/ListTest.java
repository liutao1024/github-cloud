package org.cloud.mvn.zstudy.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		test001();
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
	
	public static void listIteratorTest(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(8);
		list.add(-2);
		list.add(-7);
		
		
	}
}
