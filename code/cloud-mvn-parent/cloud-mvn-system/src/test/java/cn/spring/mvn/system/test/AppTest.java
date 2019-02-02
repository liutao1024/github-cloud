package cn.spring.mvn.system.test;

import org.junit.Test;

import cn.spring.mvn.system.enums.CRDENTIALS;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * :-)    :-(  (-:)   (-:(
	 */
	@Test
	public void TestEnum(){
//		Object obj = CRDENTIALS.HUKOUBO.getValue();
//		System.out.println(CRDENTIALS.HUKOUBO.compareTo(CRDENTIALS.ZHANZHUZHENG));
//		System.out.println(obj.toString());
//		System.out.println(CRDENTIALS.HUKOUBO.toString());
		System.out.println(CRDENTIALS.HUKOUBO.equals(CRDENTIALS.SHENGFENZHENG));
		System.out.println(CRDENTIALS.HUKOUBO.equals(CRDENTIALS.SHENGFENZHENG));
	}
}
