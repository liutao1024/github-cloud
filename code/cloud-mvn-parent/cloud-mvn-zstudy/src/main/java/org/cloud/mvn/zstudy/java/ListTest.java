package org.cloud.mvn.zstudy.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

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
//		listIteratorTest();
//		linkedListTest();
//		performanceTest();
		priorityQueueTest();
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
	/**
	 * @Author LiuTao @Date 2020年8月3日 上午10:46:49 
	 * @Title: linkedListTest 
	 * @Description: TODO(Describe)
	 */
	public static void linkedListTest(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Oracle");
		linkedList.add("Mybatis");
		linkedList.add("Java");
		linkedList.offer("MySQL 5.5");
		linkedList.push("C++");
		linkedList.offerFirst("C#");
		linkedList.offerLast("Python");
//		Iterator<String> it = linkedList.iterator();
//		while (it.hasNext()) {
//			System.out.print(it.next()+"  ");
//		}
		System.out.println(linkedList);
		System.out.println(linkedList.peekFirst());
		System.out.println(linkedList.peekLast());
		System.out.println(linkedList);
		System.out.println(linkedList.pop());
		System.out.println(linkedList.pollFirst());
		System.out.println(linkedList.pollLast());
		System.out.println(linkedList);
	}
	/**
	 * @Author LiuTao @Date 2020年8月3日 上午10:46:57 
	 * @Title: performanceTest 
	 * @Description: TODO(Describe)
	 */
	public static void performanceTest(){
		int x = 1000000;
		String[] array = new String[x];
		for (int i = 0; i < x; i++) {
			array[i] = String.valueOf(i);
		}
		//插入集合
		Long start = System.currentTimeMillis();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < x; i++) {
			arrayList.add(array[i]);
		}
		Long end = System.currentTimeMillis();
		System.out.println("插入ArrayList集合元素用时:" + (end - start) + "");
		start = System.currentTimeMillis();
		Vector<String> vector = new Stack<String>();
		for (int i = 0; i < x; i++) {
			vector.add(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("插入Vector集合元素用时:" + (end - start) + "");
		start = System.currentTimeMillis();
		LinkedList<String> linkedList = new LinkedList<String>();
		for (int i = 0; i < x; i++) {
			linkedList.add(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("插入LinkedList集合元素用时:" + (end - start) + "");
		System.out.println(arrayList.size());
		System.out.println(vector.size());
		System.out.println(linkedList.size());
		//迭代集合用时
		start = System.currentTimeMillis();
		for (Iterator<String> it = arrayList.iterator(); it.hasNext(); ) {
			it.next();
		}
		end = System.currentTimeMillis();
		System.out.println("迭代访问ArrayList集合元素用时:" + (end - start) + "");
		start = System.currentTimeMillis();
		for (Iterator<String> it = vector.iterator(); it.hasNext(); ) {
			it.next();
		}
		end = System.currentTimeMillis();
		System.out.println("迭代访问Vector集合元素用时:" + (end - start) + "");
		start = System.currentTimeMillis();
		for (Iterator<String> it = linkedList.iterator(); it.hasNext(); ) {
			it.next();
		}
		end = System.currentTimeMillis();
		System.out.println("迭代访问LinkedList集合元素用时:" + (end - start) + "");
		//删除集合
		start = System.currentTimeMillis();
		for (int i = 0; i < x; i++) {
			arrayList.remove(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("删除ArrayList集合元素用时:" + (end - start) + "");
		start = System.currentTimeMillis();
		for (int i = 0; i < x; i++) {
			vector.remove(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("删除Vector集合元素用时:" + (end - start) + "");
		start = System.currentTimeMillis();
		for (int i = 0; i < x; i++) {
			linkedList.remove(array[i]);
		}
		end = System.currentTimeMillis();
		System.out.println("删除LinkedList集合元素用时:" + (end - start) + "");
	}
	
	public static void priorityQueueTest(){
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.offer("X");
		queue.offer("D");
		queue.offer("B");
		queue.offer("L");
		queue.offer("T");
		queue.offer("A");
		System.out.println(queue);
	}
}
