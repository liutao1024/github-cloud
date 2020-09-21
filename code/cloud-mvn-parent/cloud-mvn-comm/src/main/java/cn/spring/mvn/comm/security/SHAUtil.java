package cn.spring.mvn.comm.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author LiuTao @Date 2020年9月18日 上午9:58:29
 * @ClassName: SHAUtil 
 * @Description: SHA(Secure Hash Algorithm,安全散列算法)
 */
public class SHAUtil {
	public static final String KEY_SHA = "SHA";  
    public static final String ALGORITHM = "SHA-256";
	
	/***
	 * SHA加密(比MD5更安全)
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception{
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}
	
	/**
	 * @Author LiuTao @Date 2020年9月19日 下午9:07:40 
	 * @Title: SHAEncrypt 
	 * @Description SHA加密
	 * @param content 报文?
	 * @return
	 */
	public static String SHAEncrypt(String content) {
        try {
            MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
            byte[] sha_byte = sha.digest(content.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (byte b : sha_byte) {
                //将其中的每个字节转成十六进制字符串:byte类型的数据最高位是符号位,通过和0xff进行与操作,转换为int类型的正整数.
                String toHexString = Integer.toHexString(b & 0xff);
                hexValue.append(toHexString.length() == 1 ? "0" + toHexString : toHexString);
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return "";
    }
    
    /**
     * @Author LiuTao @Date 2020年9月19日 下午9:11:09 
     * @Title: SHA256Encrypt 
     * @Description: SHA-256加密
     * @param sourceStr
     * @return
     */
    public static String SHA256Encrypt(String sourceStr) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (null != md) {
            md.update(sourceStr.getBytes());
            String digestStr = getDigestStr(md.digest());
            return digestStr;
        }
        return null;
    }
 
    /**
     * @Author LiuTao @Date 2020年9月19日 下午9:12:16 
     * @Title: getDigestStr 
     * @Description: 数字化
     * @param origBytes
     * @return 纯数字的字符串
     */
    public static String getDigestStr(byte[] origBytes) {
        String tempStr = null;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < origBytes.length; i++) {
            tempStr = Integer.toHexString(origBytes[i] & 0xff);
            if (tempStr.length() == 1) {
                stb.append("0");
            }
            stb.append(tempStr);
        }
        return stb.toString();
    }
    
    /**
     * @Author LiuTao @Date 2020年9月19日 下午9:12:40 
     * @Title: main 
     * @Description: SHA加密测试主类 
     * @param args
     */
    public static void main(String[] args) {
		//加密
    	String str = "159liudaye520tao";
    	String sha = SHAEncrypt(str);
    	String sha256 = SHA256Encrypt(str);
    	System.out.println(sha);
    	System.out.println(sha256);
    	
    	System.out.println(getDigestStr(sha.getBytes()));
    	System.out.println(getDigestStr(sha256.getBytes()));
    	
    	
	}
}
