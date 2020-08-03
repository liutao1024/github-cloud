package org.cloud.mvn.zstudy.java;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;

public class MapTest {
	public static void main(String[] args) {
		hashMapAndHashtableTest();
	}
	public static void hashMapAndHashtableTest(){
		Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		Map<String, Object> hashtable = new Hashtable<String, Object>();
		hashMap.put("Name", "LiuTao");
		hashMap.put("Age", 24);
		hashMap.put("Sex", "man");
		hashMap.put("Weight", "24");
		System.out.println(hashMap.containsValue(24));
		for (String key : hashMap.keySet()) {
			hashMap.get(key);
		}
//		for (Object value : hashMap.values()) {
//			String key = hashMap.
//		}
		for (Entry<String, Object> entry : hashMap.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
		
		
	}
}
