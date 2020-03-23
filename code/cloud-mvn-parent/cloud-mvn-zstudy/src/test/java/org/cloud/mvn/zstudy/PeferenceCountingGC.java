package org.cloud.mvn.zstudy;

@SuppressWarnings("unused")
public class PeferenceCountingGC {
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	private byte[] bigsize = new byte[2 * _1MB];
	/**
	 * @author LiuTao @date 2020年2月13日 下午6:48:43 
	 * @Title: testGC 
	 * @Description: TODO(Describe)
	 */
	public static void testGC(){
		PeferenceCountingGC objA = new PeferenceCountingGC();
		PeferenceCountingGC objB = new PeferenceCountingGC();
		
		objA.instance = null;
		objB.instance = null;
		
		objA = null;
		objB = null;
		
		System.gc();
	}
	/**
	 * @author LiuTao @date 2020年2月13日 下午6:45:26 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
//		testGC();
		HashCode();
	}
	
	public static void HashCode(){
		String str1 = "通话";
		String str2 = "重地";
		System.out.println(String.format("Str1: %d  | Str2: %d", str1.hashCode(), str2.hashCode()));
		System.out.println(str1.equals(str2));
	}
}
