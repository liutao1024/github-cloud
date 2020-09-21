package cn.spring.mvn.comm.security;

import org.apache.shiro.codec.Base64;

/**
 * @Author LiuTao @Date 2020年9月18日 上午9:23:06
 * @ClassName: Base64Util 
 * @Description: BASE64加密/解密
 */
public class Base64Util {
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:01:43 
	 * @Title: encode 
	 * @Description: 编码---加密
	 * @param bytes
	 * @return
	 */
	public static String encode(byte[] bytes){
		return new String(Base64.encode(bytes));
	}
	/**
	 * @Author LiuTao @Date 2020年9月17日 下午10:01:39 
	 * @Title: decode 
	 * @Description: 解码---解密
	 * @param bytes
	 * @return
	 */
	public static String decode(byte[] bytes){
		return new String(Base64.decode(bytes));
	}

}
