package org.cloud.mvn.zstudy.encryptionAndDecryption;

import org.apache.shiro.codec.Base64;

public class Base64Coded {

	public static void main(String[] args) {
		String string = "qianyang123";
		//编码
		String encode = encode(string.getBytes());
		System.out.println(string + "\t编码后的字符串为:" + encode);
		//解码
		String decode = decode(encode.getBytes());
		System.out.println(encode + "\t字符串解码后为:" + decode);
	}
	
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:01:39 
	 * @Title: decode 
	 * @Description: 解码
	 * @param bytes
	 * @return
	 */
	public static String decode(byte[] bytes){
		return new String(Base64.decode(bytes));
	}
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:01:43 
	 * @Title: encode 
	 * @Description: 编码
	 * @param bytes
	 * @return
	 */
	public static String encode(byte[] bytes){
		return new String(Base64.encode(bytes));
	}
}
