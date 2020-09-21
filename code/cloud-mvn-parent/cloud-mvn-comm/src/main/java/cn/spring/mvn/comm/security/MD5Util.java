package cn.spring.mvn.comm.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

import org.apache.commons.lang3.Validate;

import cn.spring.mvn.basic.exception.Exceptions;

/**
 * @author LiuTao @date 2018年5月13日 下午8:45:58
 * @ClassName: MD5Util 
 * @Description: MD5(Message Digest Algorithm)加密的不可逆性,没有解密方法)
 */
public class MD5Util {
	private static final String MD5 = "MD5";
	private static final String SHA1 = "SHA-1";
	private static SecureRandom random = new SecureRandom();
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
          "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:39:43 
	 * @Title: md5EncryptFile 
	 * @Description: TODO(MD5加密文件) 
	 * @param file
	 * @return
	 */
	public static String md5EncryptFile(String file) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
//			 localMessageDigest.update(IOHelper.toBytes(new FileInputStream(file)));
			byte[] arrayOfByte = localMessageDigest.digest();

			StringBuffer localStringBuffer = new StringBuffer("");
			for (int j = 0; j < arrayOfByte.length; j++) {
				int i = arrayOfByte[j];
				if (i < 0)
					i += 256;
				if (i < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i));
			}
			return localStringBuffer.toString();
		} catch (Throwable localThrowable1) {
			localThrowable1.printStackTrace();
		}
		return null;
	}
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:39:59 
	 * @Title: md5EncryptString 
	 * @Description: TODO(MD5加密字符串) 
	 * @param str
	 * @return
	 */
	public static String md5EncryptString(String str) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(str.getBytes());
			byte[] arrayOfByte = localMessageDigest.digest();
			StringBuffer localStringBuffer = new StringBuffer("");
			for (int j = 0; j < arrayOfByte.length; j++) {
				int i = arrayOfByte[j];
				if (i < 0)
					i += 256;
				if (i < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i));
			}
			return localStringBuffer.toString();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {
			localNoSuchAlgorithmException1.printStackTrace();
		}
		return null;
	}
	/***
	 * MD5加密(生成唯一的MD5值)
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryMD5(byte[] data) throws Exception {
		MessageDigest MD = MessageDigest.getInstance(MD5);
		MD.update(data);
		return MD.digest();
	}
	
	
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:39:29 
	 * @Title: md5EncryptArray 
	 * @Description: TODO(Describe) 
	 * @param str
	 * @return
	 */
	public static String md5EncryptArray(byte[] str) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance(MD5);
			localMessageDigest.update(str);
			byte[] arrayOfByte = localMessageDigest.digest();
			StringBuffer localStringBuffer = new StringBuffer("");
			for (int j = 0; j < arrayOfByte.length; j++) {
				int i = arrayOfByte[j];
				if (i < 0)
					i += 256;
				if (i < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i));
			}
			return localStringBuffer.toString();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {
			localNoSuchAlgorithmException1.printStackTrace();
		}
		return null;
	}
	/**
	 * @author LiuTao @date 2018年6月12日 下午1:25:10 
	 * @Title: getSerial 
	 * @Description: 生成一个流水号
	 * @return
	 */
	public static String getSerial(){
		UUID uuid = UUID.randomUUID();
		String serial = uuid.toString().replaceAll("-", "");
		return serial;
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:37:40 
	 * @Title: sha1 
	 * @Description: 对输入字符串进行sha1散列. 
	 * @param input
	 * @return
	 */
	public static byte[] sha1(byte[] input) {
		return digest(input, SHA1, null, 1); 
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:37:33 
	 * @Title: sha1 
	 * @Description: TODO(Describe) 
	 * @param input
	 * @param salt
	 * @return
	 */
	public static byte[] sha1(byte[] input, byte[] salt) {
		return digest(input, SHA1, salt, 1);
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:37:29 
	 * @Title: sha1 
	 * @Description: TODO(Describe) 
	 * @param input
	 * @param salt
	 * @param iterations
	 * @return
	 */
	public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input, SHA1, salt, iterations);
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:37:20 
	 * @Title: GetMD5Code 
	 * @Description: 字符串转成MD5字符串
	 * @param strObj
	 * @return
	 */
   public static String GetMD5Code(String strObj) {
        String resultString = null; 
        try {
            resultString = new String(strObj);
            InputStream in= new ByteArrayInputStream(strObj.getBytes());
            resultString = byteToString(md5(in));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:37:08 
	 * @Title: digest 
	 * @Description: 对字符串进行散列, 支持md5与sha1算法
	 * @param input
	 * @param algorithm
	 * @param salt
	 * @param iterations
	 * @return
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			if (salt != null) {
				digest.update(salt);
			}
			byte[] result = digest.digest(input);
			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw Exceptions.unchecked(e);
		}
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:36:46 
	 * @Title: generateSalt 
	 * @Description: 生成随机的Byte[]作为salt.
	 * @param numBytes byte数组的大小
	 * @return
	 */
	public static byte[] generateSalt(int numBytes) {
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);
		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:36:35 
	 * @Title: md5 
	 * @Description: 对文件进行md5散列. 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static byte[] md5(InputStream input) throws IOException {
		return digest(input, MD5);
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:35:42 
	 * @Title: sha1 
	 * @Description: 对文件进行sha1散列.
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static byte[] sha1(InputStream input) throws IOException {
		return digest(input, SHA1);
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:35:54 
	 * @Title: digest 
	 * @Description: TODO(Describe) 
	 * @param input
	 * @param algorithm
	 * @return
	 * @throws IOException
	 */
	private static byte[] digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 8 * 1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}
			return messageDigest.digest();
		} catch (GeneralSecurityException e) {
			throw Exceptions.unchecked(e);
		}
	}
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:36:04 
	 * @Title: byteToArrayString 
	 * @Description: 返回形式为数字跟字符串 
	 * @param bByte
	 * @return
	 */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
	/**
	 * @author LiuTao @date 2019年2月1日 下午2:36:16 
	 * @Title: byteToString 
	 * @Description: 转换字节数组为16进制字串 
	 * @param bByte
	 * @return
	 */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    /**
	 * @author LiuTao @date 2018年5月13日 下午8:51:04 
	 * @Title: Md5 
	 * @Description: TODO(Describe) 
	 * @param plainText
	 */
	public static void Md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0){
					i += 256;
				}
				if (i < 16){
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			System.out.println("result: " + buf.toString());// 32位的加密
			System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:52:03 
	 * @Title: MD5 
	 * @Description: TODO(MD5加码-32位) 
	 * @param inStr
	 * @return
	 */
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++){
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * @author LiuTao @date 2018年5月13日 下午8:53:02 
	 * @Title: KL 
	 * @Description: TODO(可逆的加密算法) 
	 * @param inStr
	 * @return
	 */
	public static String KL(String inStr) {
		// String s = new String(inStr);
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:53:20 
	 * @Title: JM 
	 * @Description: TODO(加密后解密) 
	 * @param inStr
	 * @return
	 */
	public static String JM(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:53:39 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		Md5("123456");
		System.out.println();
		String s = new String("123456");
		
		
		System.out.println("原始：" + s);
		System.out.println(KL(s));
		System.out.println(JM(KL(s)));
//		System.out.println("MD5后：" + MD5(s));
//		System.out.println("MD5后再加密：" + KL(MD5(s)));
//		System.out.println("解密为MD5后的：" + JM(KL(MD5(s))));
//		System.out.println("解密为MD5后的：" + JM(MD5(s)));
		
	}

}
