package org.cloud.mvn.zstudy.java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
//		System.out.println(new A() == new A());
//		System.out.println(new A().equals(new A()));
//		setTest();
//		hashSetTest();
//		sameHashCodeTest();
//		equalsTrueTest();
//		hashSetOrderTest();
//		linkedHashSetOrderTest();
//		treeSetTest();
//		objectCompareToTest();
		objectComparatorTest();
	}
	public static void setTest() {
		Set<Object> set = new HashSet<Object>();
		A a = new A();
		B b = new B();
		C c = new C();
		set.add(a);
		set.add(a);
		set.add(b);
		set.add(b);
		set.add(c);
		set.add(c);
		for (Object object : set) {
			System.out.println(object);
		}
		System.out.println(set);

	}
	public static void hashSetTest(){
		HashSet<Object> hashSet = new HashSet<Object>();
		hashSet.add(new A());
		hashSet.add(new A());
		hashSet.add(new B());
		hashSet.add(new B());
		hashSet.add(new C());
		hashSet.add(new C());
		Iterator<Object> it = hashSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(hashSet);
	}
	public static void sameHashCodeTest(){
		HashSet<Object> set = new HashSet<Object>();
		set.add(new D());
		set.add(new D());
		System.out.println(set);
	}
	public static void equalsTrueTest(){
		Set<Object> set = new HashSet<Object>();
		set.add(new A());
		set.add(new A());
		System.out.println(set);
	}
	/**
	 * @Author LiuTao @Date 2020年7月23日 下午2:39:43 
	 * @Title: changObjectSetTest 
	 * @Description: HashSet中数据看似无序,实则有序(由对象的hashCode值决定顺序)
	 */
	public static void hashSetOrderTest(){
		HashSet<R> set = new HashSet<R>();
		set.add(new R(-3));
		set.add(new R(9));
		set.add(new R(-2));
		set.add(new R(5));
		set.add(new R(0));
		set.add(new R(3));
		System.out.println(set);
		Iterator<R> it = set.iterator();
		R r = it.next();
		r.value = 5;
		System.out.println(set);
		set.remove(new R(-2));
		System.out.println(set);
		System.out.println("set是否包含value为5的R对象:" + set.contains(new R(5)));
		System.out.println("set是否包含value为-2的R对象:" + set.contains(new R(-2)));
	}
	/**
	 * @Author LiuTao @Date 2020年7月23日 下午2:46:14 
	 * @Title: linkedHashSetOrderTest 
	 * @Description: LinkedHashSet由链表维护set的顺序(元素先后顺序),性能低于hashSet
	 */
	public static void linkedHashSetOrderTest(){
		LinkedHashSet<R> set = new LinkedHashSet<R>();
		set.add(new R(-3));
		set.add(new R(9));
		set.add(new R(-2));
		set.add(new R(5));
		set.add(new R(0));
		set.add(new R(3));
		System.out.println(set);
		Iterator<R> i = set.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
	public static void treeSetTest(){
		TreeSet<Object> set = new TreeSet<Object>();
		set.add("X");
		set.add("E");
		set.add("C");
		set.add("f");
		set.add("b");
		set.add("B");
		set.add("2");
		set.add("-3");
		set.add("0");
		set.add("-2");
		System.out.println(set);
		System.out.println(set.first());
		System.out.println(set.last());
		System.out.println(set.headSet("D"));
		System.out.println(set.tailSet("4"));
	}
	
	public static void objectCompareToTest(){
		BigDecimal a = new BigDecimal("12");
		BigInteger b = new BigInteger("12");
		
		TreeSet<Object> set = new TreeSet<Object>();
		set.add(a);
		set.add(b);
		
	}
	/**
	 * @Author LiuTao @Date 2020年7月30日 上午9:39:36 
	 * @Title: objectComparatorTest 
	 * @Description: TreeSet定制排序
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void objectComparatorTest(){
		TreeSet set = new TreeSet(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				M m1 = (M)o1;
				M m2 = (M)o2;
				int rt = 0;
				if(m1.age > m2.age)
					rt = -1;
				if(m1.age < m2.age)
					rt = 1;
				return rt;
			}
			
		});
		set.add(new M(5));
		set.add(new M(2));
		set.add(new M(8));
		set.add(new M(-4));
		set.add(new M(-1));
		System.out.println(set);
	}
	
	public static void enumSetTest(){
		EnumSet es1 = EnumSet.allOf(Season.class);
		System.out.println(es1);
		EnumSet es2 = EnumSet.noneOf(Season.class);
		System.out.println(es2);
		EnumSet es3 = EnumSet.of(Season.SUMMER,Season.WINTER);
		System.out.println(es3);
		EnumSet es4 = EnumSet.range(Season.SUMMER,Season.WINTER);
		System.out.println(es4);
		EnumSet es5 = EnumSet.complementOf(es4);
		System.out.println(es5);
		
		
		
	}
}

enum Season{
	SPRING,SUMMER,FALL,WINTER
}
class A {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
class B {
	@Override
	public int hashCode() {
		return 1;
	}
}
class C {
	@Override
	public int hashCode() {
		return 2;
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
class D {
	@Override
	public int hashCode() {
		return 3;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
class R {
	int value;
	public R(int value) {
		this.value = value;
	}
//	public int getValue() {
//		return value;
//	}
//	public void setValue(int value) {
//		this.value = value;
//	}
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + value;
//		return result;
		return this.value;
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		R other = (R) obj;
//		if (value != other.value)
//			return false;
//		return true;
		if(obj instanceof R){
			R r = (R) obj;
			if(r.value == this.value)
				return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "R[value=" + value + "]";
	}
}
class X<T> implements Comparable<T> {

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class M {
	int age;
	public M(int age){
		this.age = age;
	}
	@Override
	public String toString() {
		return "M [age=" + age + "]";
	}
	
}