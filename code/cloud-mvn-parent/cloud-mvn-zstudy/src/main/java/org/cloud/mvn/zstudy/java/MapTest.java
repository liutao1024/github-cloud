package org.cloud.mvn.zstudy.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		hashMapAndHashtableTest();
	}
	/**
	 * @Author LiuTao @Date 2020年8月4日 上午9:09:58 
	 * @Title: hashMapAndHashtableTest 
	 * @Description: TODO(Describe)
	 */
	public static void hashMapAndHashtableTest(){
		Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		Map<String, Object> hashtable = new Hashtable<String, Object>();
		hashMap.put("Name", "LiuTao");
		hashMap.put("Age", 8);
		hashMap.put("Sex", "man");
		hashMap.put("Weight", "8");
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
			if("Age".equals(key))
				entry.setValue("24");
		}
		System.out.println(hashMap.containsKey("Birth"));
		System.out.println(hashMap.containsValue(8));
		Collection<Object> cl = hashMap.values();
		System.out.println(cl);
	}
}
