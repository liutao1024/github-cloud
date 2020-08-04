package org.cloud.mvn.zstudy.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * @Author LiuTao @Date 2020年8月4日 下午9:19:43
 * @ClassName: MapTest 
 * @Description: HashMap介绍:https://blog.csdn.net/qq_41345773/article/details/92066554
 */
public class MapTest {
	public static void main(String[] args) {
		hashMapAndHashtableTest();
		linkedHashMap();
	}
	/**
	 * @Author LiuTao @Date 2020年8月4日 上午9:09:58 
	 * @Title: hashMapAndHashtableTest 
	 * @Description: HashMap不会根据存入的元素的顺序进行排序,而是根据,key-value键值对中key的hashCode值进行自然排序????
	 */
	public static void hashMapAndHashtableTest(){
		Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		Map<String, Object> hashtable = new Hashtable<String, Object>();
		hashMap.put("Name", "LiuTao");
		hashMap.put("Age", 8);
		hashMap.put("Sex", "man");
		hashMap.put("Weight", "8");
		System.out.println(hashMap);
		System.out.println(hashMap.containsValue(24));
		Set<String> keySet = hashMap.keySet();
		System.out.println(keySet);
		for (String key : hashMap.keySet()) {
			hashMap.get(key);
		}
//		for (Object value : hashMap.values()) {
//			String key = hashMap.
//		}
		Set<Entry<String, Object>> e = hashMap.entrySet();
		System.out.println(e);
		for (Entry<String, Object> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("Value的类名称:" + entry.getValue().getClass());
			if("Age".equals(key))
				entry.setValue("24");
		}
		System.out.println(hashMap.containsKey("Birth"));
		System.out.println(hashMap.containsValue(8));
		Collection<Object> cl = hashMap.values();
		System.out.println(cl);
	}
	/**
	 * @Author LiuTao @Date 2020年8月4日 下午8:10:33 
	 * @Title: linkedHashMap 
	 * @Description: TODO(Describe)
	 */
	public static void linkedHashMap(){
		LinkedHashMap<String, Object> lhm = new LinkedHashMap<String, Object>();
		lhm.put("Java", 89);
		lhm.put("Android", 99);
		lhm.put("C++", 95);
		lhm.put("Oracle", 100);
		lhm.put("MYSQL", 76);
		System.out.println(lhm);
		for (Entry<String, Object> entry : lhm.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}
