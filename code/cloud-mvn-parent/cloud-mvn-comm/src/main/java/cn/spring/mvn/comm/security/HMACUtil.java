package cn.spring.mvn.comm.security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author LiuTao @Date 2020年9月18日 上午9:51:36
 * @ClassName: HMACUtil 
 * @Description: HMAC(Hash Message Authentication Code,散列消息鉴别码)
 */
public class HMACUtil {
public static final String KEY_MAC = "HmacMD5";  
	
	/***
	 * 初始化HMAC密钥
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception{
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
		SecretKey secreKey = keyGenerator.generateKey();
		return Base64Util.encode(secreKey.getEncoded());
	}
	
	/**
	 * HMAC加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryHMAC(byte[] data, String key) throws Exception{
		SecretKey secreKey = new SecretKeySpec(Base64Util.encode(key.getBytes()).getBytes(), KEY_MAC);
		Mac mac = Mac.getInstance(secreKey.getAlgorithm());
		mac.init(secreKey);
		return mac.doFinal();
	}

}
