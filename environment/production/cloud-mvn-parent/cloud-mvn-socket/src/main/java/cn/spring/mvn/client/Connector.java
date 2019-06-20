package cn.spring.mvn.client;

import java.util.Map;

import cn.spring.mvn.client.model.ApSysServs;

/**
 * @Author LiuTao @Date 2018年10月16日 上午9:24:07
 * @ClassName: Connector 
 * @Description:连接器
 */
public interface Connector {

	/**
	 * @author LiuTao @date 2018年10月16日 上午9:24:20 
	 * @Title: communication 
	 * @Description: 通讯
	 * @param send
	 * @param rspMsgCd
	 * @param serv
	 * @return
	 */
	String communication(byte[] sendMsg, ApSysServs apSysServs);

	Map<String, Object> sendMsg(byte[] sendBuffer, String rspMsgCd, ApSysServs serv);
}
