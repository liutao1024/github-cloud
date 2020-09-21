package org.cloud.mvn.zstudy.encryptionAndDecryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.shiro.codec.Base64;
/**
 * @Author LiuTao @Date 2020年9月17日 下午10:41:40
 * @ClassName: RSAEncrypt 
 * @Description: RSA加密必须同时提供公钥以及私钥,才能顺利的完成加密解密过程,在相互交互的两个系统之间为了数据安全性都会对通讯的报文进行加密处理
 * 	此时用到多种加解密方式,RSA是其中一种,现在接触的京东好像就是这样的,公钥和私钥是否和当前的操作系统有关,比如说我在系统A生成的公钥和私钥在服务器B上是否同样使用
 * 验证方法:将代码上传至github上在笔记本上进行验证 ---20200917 
 */
public class RSAEncrypt {
	private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:18:47 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * 1.公钥后面加字符串后一样可以加解密成功
		 * 2.私钥后面加字符串后一样可以加解密成功   网友说是因为截取得固定长度密钥导致,加在密钥前面是不会成功,而加在后面是成功的
		 * 3.私钥加密公钥解密报错--确实报错------私钥加密,公钥解密?公钥加密,私钥解密??
		 * 是否可以实现 私钥加密 公钥解密,
		 */
		//生成公钥和私钥
		genKeyPair();
		System.out.println("随机生成的公钥为:" + keyMap.get(0));
		System.out.println("随机生成的私钥为:" + keyMap.get(1));
//		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCXZO+XQ4qnahtu3yKo8L1pB1AqtXDUu0IexnVKedZ8jGFRpMxnM5hSGUjcNPf64+Etjo+nsp0wJDq4J3H0yBSnyvO7/aBt24NFIFm12qo4U6zdlK7fto2EZqC3jSGW0gSG5AXbGbNAeGJWxFjrkDg1VfO9AZqJB5LQYnwwSu84+wIDAQAB";
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJ3fb+tztMXDpEuj2kt2G203QcsEzwLiy6JpvXcNYmU+FidsCOLLghjZvnAAz3LThBBSJ3FAoxyj446i3z8zvsJKoTaWoC5TiiI7JImFd9EPrilHv5DJdcPjIck31ZVUjZ5cDsD9aKnatGVD1HpVHKLJgTmQI+F7mwAyJ8cOq0XQIDAQAB";
//		String privetKey = "MMIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJdk75dDiqdqG27fIqjwvWkHUCq1cNS7Qh7GdUp51nyMYVGkzGczmFIZSNw09/rj4S2Oj6eynTAkOrgncfTIFKfK87v9oG3bg0UgWbXaqjhTrN2Urt+2jYRmoLeNIZbSBIbkBdsZs0B4YlbEWOuQODVV870BmokHktBifDBK7zj7AgMBAAECgYEAkL71f7cY4xXE4s0+My3wunE+iYbuOMZM4mW2kJ1Kn8wL4+Zfc7BVyvDXw4p1KZAko8zwtlJEjVmmNpmoD3QYohPYkMfJaToG9E4PMNgtnSmMB15X9kWIf3itHe0+RMg3KBWmcWpcsxYsvwrI+94XSegV/KTR9zz8uWMpXm4K2pECQQDlCT/ldc6DWaQlHcqkOF7+wxtSfr6Fmc3O1U48zvROI6GBsNK6HWSvAYAOuCU/16rEOju4L8a79RaePzEqAEPZAkEAqTeyMMLU5ptFz59NM0nsStZVBSn+oQmXdsjY5O+YdV/2FCTNRqA+CKHfXFIWWccHWrh10LBflU7v8j018Ywi8wJAAxmP8tQYWnDBJvtzPavBpWMQoJo0i+xb+7upVmtapSAYVIAHKhuxvCiiChD1+Bo8JnG/UyvaXbrgdn3WdYIRaQJARsk0si8eTmVPu72A1t6qiNfF8wYRLR5NDPSRvpr3pMoCr4SBlnS73nKQdBcmoGGgkvOs3SKaqWO+/g9a/HNJvwJBAJn5rZfrN7wZreV+MKGYhZpaxfvEQgGpycb8ZzeufjJigMBhCphDmthX6ATDjavcXWFM11J5nURFTkZaBEOtYBI="; 
		String privetKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMnd9v63O0xcOkS6PaS3YbbTdBywTPAuLLomm9dw1iZT4WJ2wI4suCGNm+cADPctOEEFIncUCjHKPjjqLfPzO+wkqhNpagLlOKIjskiYV30Q+uKUe/kMl1w+MhyTfVlVSNnlwOwP1oqdq0ZUPUelUcosmBOZAj4XubADInxw6rRdAgMBAAECgYAQFbWmmicJcJfb/hMHWu1YSgUIfCvFP4ik1Iq6Ye1OZISi+d9h9MI/Oi9f+qsNzvaah7Q1VM1zJjBLDK3YsFrn07J0WPMdyG1XdjHBfj5VMFNCTA271YnFlDCANHv4OwPs+Yufh2plCRiKGQV2ISflbM4kLnOmEJuykJFOeGUs6QJBAPbNg22kuBxolz63TCpur8FRBou+ygNtq/72cX8azM53GElyBFloQQOy+znakrcaG8GjVu7TkcamtSsjRdfhtWMCQQDRY8RFhzFQjWBQ3sOP8Kxu6yDMcFIS/KFYhnVmV+zCnsXBJPyLr6mdOe0ZCNbsKEJvGGCq+ZrA9QSiqnM0jfs/AkEApdguFBSXH4fs8ljr1quwcQBInMllKG6fIGJsnBPfQnJnIJt8brQO1DSGezb0VhQ2SKXBOhVzpQDLRySZv1rNrwJBAJqI9yIZVNwOezc0MUDab2itP9eiTfCVYr7i/WI7IhHA/FI/6eNuEdBoIASJ8ZT5YY58f1uwO/aM3o7vHXd8EiECQQDANLraSn3r6oxZ2L+aE3gw6il6yYaK2PjGCc3p3kDl19YcfeJiZaDCPQf7F05fZNAMizfG8g52iLompk5y2BAE"; 
		
		//待加密的字符串
		String message = "159liutao";
//		String messageEn = encrypt(message, keyMap.get(0));
		String messageEn = encrypt(message, publicKey);
		System.out.println("加密后的字符串为:" + messageEn);
		/**
		 * F4ilvD0rPF7f8TdRR1yCzYxYMUgXBt8uIeoKPf3/x2rsydsNPWCThHYaIxph5sakbZQepVS64X+8J+tWUvfYsBzrIJrEoK5zzCivDF0mHzUfBkDN6GlHyJs1Z9x5t3t+LXZCXZSVAZenwf7aGvgMmx4MmZuCQiqeYZO0aESOqZ4=
		 * G9pYL5zCGJmiANeNPixQRlK08w5ytHyvbbyHn1RmxUif9Vx6vL+w25yiLXCvbdvgCbyAwtJhbNfR/QOCY6PdJ/skkYpC+/NjriyAtEHXZzIWrMwpINAWCXCoanL6mJ/AlH+RBUkApatLE1LTKvq0l3LFMIjlVJz5cprQ1IDUohs=
		 * j1g3JsTsg8j0SvWqIn3oEnodOReNDZdvhENi+yXo3eNJHkW4OVAKFbPoiGGoJUHfCvDNTB6uBzoYEzX0sergMlZEnLVEPZWEaaBtBp1apHzIlInZieOTvwrv5QnjVZVgFf0gzResb3IRhNV+vLPwJoY/Amjrk8P4+u0V46Sfwbk=
		 * daaWje6fpTdUdiqeV78xq2pqR6ui8SQ1k0g7tItpNl+FULDtnucQlGEpg5yerFHG7uZM+jTpVTPSjb7E1PF4YEFEk9QbfN4j/nuLT6KAiM7t7KmAcfH5QNwkY/YgbDw3LgS/Cil5mOTfCEaPpQrlvIYOziM0YjlHi9F2pPBsUYc=
		 */
//		String messageDe = decrypt(messageEn, keyMap.get(1));
//		String messageDe = decrypt(messageEn, privetKey);
		String messageDe = decrypt("FU0+lL5CM/9pb+ayc+E+OSuL+4GY/bNPfYuQsiEi5tnqnkE9uoub+SvVGMTkwPXYTKGz6KaimY41P6zAIvAk/U+9Q6oukp5YrtGthr5merB6rZKRQQoQ7zGg4eBvME2WDCppLAci3yxCJe9UdOIMyIkC18UU4grDF21G8NpL2GI=", privetKey);
		System.out.println("还原后的字符串为:" + messageDe);
	}

	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:15:09 
	 * @Title: genKeyPair 
	 * @Description: 随机生成密钥对  
	 * @throws NoSuchAlgorithmException
	 */
	public static void genKeyPair() throws NoSuchAlgorithmException {  
		// KeyPairGenerator类用于生成公钥和私钥对,基于RSA算法生成对象  
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
		// 初始化密钥对生成器,密钥大小为96-2048位  
		keyPairGen.initialize(2048, new SecureRandom());  
		// 生成一个密钥对,保存在keyPair中  
		KeyPair keyPair = keyPairGen.generateKeyPair();  
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥  
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥  
//		String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));  
		String publicKeyString = new String(Base64.encode(publicKey.getEncoded()));  
		// 得到私钥字符串  
//		String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));  
		String privateKeyString = new String(Base64.encode((privateKey.getEncoded())));  
		// 将公钥和私钥保存到Map
		keyMap.put(0,publicKeyString);  //0表示公钥
		keyMap.put(1,privateKeyString);  //1表示私钥
	}  
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:14:19 
	 * @Title: encrypt 
	 * @Description: RSA公钥加密 
	 * @param str 加密字符串
	 * @param publicKey 公钥
	 * @return 密文 
	 * @throws Exception 加密过程中的异常信息 
	 */
	public static String encrypt(String str, String publicKey) throws Exception{
		//base64编码的公钥
//		byte[] decoded = Base64.decodeBase64(publicKey);
		byte[] decoded = Base64.decode(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
		//RSA加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
//		String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
		String outStr = Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
		return outStr;
	}

	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:13:32 
	 * @Title: decrypt 
	 * @Description: RSA 私钥解密
	 * @param str 加密字符串
	 * @param privateKey 私钥 
	 * @return 铭文
	 * @throws Exception 解密过程中的异常信息 
	 */
	public static String decrypt(String str, String privateKey) throws Exception{
		//64位解码加密后的字符串
//		byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
		byte[] inputByte = Base64.decode(str.getBytes("UTF-8"));
		//base64编码的私钥
//		byte[] decoded = Base64.decodeBase64(privateKey);  
		byte[] decoded = Base64.decode(privateKey);  
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));  
		//RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}
}