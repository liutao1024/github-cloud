package cn.spring.mvn.comm.security;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * @Author LiuTao @Date 2020年9月18日 上午9:30:34
 * @ClassName: DesUtil 
 * @Description: DES(Data Encryption Standard)对称加密/解密
 * 	 	DES 是一种对称加密算法,所谓对称加密算法就是:加密和解密使用相同密钥的算法
 */
@SuppressWarnings("restriction")
public class DESUtil {
	private static Key key;
	private static String KEY_STR = "myKey";
	private static String CHARSETNAME = "UTF-8";
	private static String ALGORITHM = "DES";
	static {
		try {
			//生成DES算法对象
			KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
			//运用SHA1安全策略
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			//设置上密钥种子
			secureRandom.setSeed(KEY_STR.getBytes());
			//初始化基于SHA1的算法对象
			generator.init(secureRandom);
			//生成密钥对象
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/***
	 * 获取加密的信息
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {
		//基于BASE64编码,接收byte[]并转换成String
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			//按utf8编码
			byte[] bytes = str.getBytes(CHARSETNAME);
			//获取加密对象
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			//初始化密码信息
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//加密
			byte[] doFinal = cipher.doFinal(bytes);
			//byte[]to encode好的String 并返回
			return encoder.encode(doFinal);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/***
	 * 获取解密之后的信息
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			//将字符串decode成byte[]
			byte[] bytes = decoder.decodeBuffer(str);
			//获取解密对象
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			//初始化解密信息
			cipher.init(Cipher.DECRYPT_MODE, key);
			//解密
			byte[] doFial = cipher.doFinal(bytes);
			return new String(doFial, CHARSETNAME);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * @Author LiuTao @Date 2020年9月19日 下午9:44:22 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "159liudaye520tao";
		String mi = getEncryptString(str);
		System.out.println(mi);
		System.out.println(getDecryptString(mi));
	}
}
