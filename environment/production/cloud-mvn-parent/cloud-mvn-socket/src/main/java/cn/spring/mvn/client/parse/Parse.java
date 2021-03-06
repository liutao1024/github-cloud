package cn.spring.mvn.client.parse;

import java.util.Map;

/**
 * @author LiuTao @date 2018年10月17日 上午9:52:39
 * @ClassName: Parse 
 * @Description: 报文封装解析接口
 */
public interface Parse {

	/**
	 * 将数据转换成字符串
	 * @param msgCd 报文号
	 * @param data  数据映射
	 * @return 字符串数据
	 */
	String encap(String msgCd,Map<String,Object> data);
	
	/**
	 * 将字符串转换成数据
	 * @param msgCd 报文号
	 * @param msg 字符串数据
	 * @return 数据映射
	 */
	Map<String,Object> unencap(String msgCd,String msg);
}
