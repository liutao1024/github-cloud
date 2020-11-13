package org.cloud.mvn.zstudy.dataStructuresAndAlgorithms.hash;

public class HashTable {
	public static int hashFunction(String key) {
		int hashVal = 0;
		for (int i = 0; i < key.length(); i++) {
			int letter = key.charAt(i) - 96;
			hashVal = (hashVal * 27 + letter);
		}
		return hashVal;
	}
}
