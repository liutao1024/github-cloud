package cn.spring.mvn.web.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.spring.mvn.basic.exception.SumpException;
import cn.spring.mvn.client.Client;
import cn.spring.mvn.client.Constants;
import cn.spring.mvn.client.Message;
import cn.spring.mvn.client.model.ApSysMsg;
import cn.spring.mvn.client.model.repository.ApSysMsgRepository;
import cn.spring.mvn.comm.security.MD5Util;
import cn.spring.mvn.comm.tools.DateTool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class WebTest {
	@Autowired
	ApSysMsgRepository apSysMsgRepository;
	@Resource
	private Message message;
	@Autowired
	private Client client;
	
	@SuppressWarnings("unused")
	@Test
	public void Test0003(){
		String str = "{"+
				"\"sys_req\":{"+
								"\"servtp\":\"MGR\","+
								"\"servno\":\"02\","+
								"\"servdt\":\"20181016\","+
								"\"servtm\":\"20:49:32:42\","+
								"\"servsq\":\"201810161120398\","+
								"\"tranbr\":\"01\","+
								"\"tranus\":\"10001\","+
								"\"trandt\":\"\","+
								"\"trantm\":\"\","+
								"\"transq\":\"\","+
								"\"status\":\"\","+
								"\"mesage\":\"\""+
							"},"+
				"\"comm_req\":{"+
								"\"corpno\":\"001\","+
								"\"prcscd\":\"qrcust\""+
							"},"+
				"\"input\":{"+
								"\"custna\":\"刘涛\""+
							"}"+
				"}";
		Map<String, Object> reqMap = new HashMap<String, Object>();//
		Map<String, Object> rspMap = new HashMap<String, Object>();//
		reqMap.put("custna", "");
		reqMap.put("userid", "10001");
		rspMap = client.callClient("qrcust", reqMap);
		System.out.println(rspMap);
	}
	
	@Test
	public void Test0002(){
		Map<String, Object> reqMap = new HashMap<String, Object>();//
		Map<String, Object> rspMap = new HashMap<String, Object>();//
		String userid = "10001";
		String passwd = MD5Util.md5EncryptString("123456");
		//是否需要校验密码
		boolean ischck = false;
		reqMap.put("userid", userid);
		reqMap.put("passwd", passwd);
		reqMap.put("ischck", ischck);
		rspMap = client.callClient("qrcust", reqMap);
		if (rspMap.get("retCode").toString().equals("0000")) {
			rspMap.put("ret", "success");
			rspMap.put("msg", "状态重置成功");
		} else {
			rspMap.put("msg", rspMap.get("retMsg").toString());	
		}
	}
	
	
	@Test
	public void Test0001() {
		Map<String, Object> reqData = new HashMap<String, Object>();
		ApSysMsg msg = apSysMsgRepository.findOne("resetsreq");
		String sendBodyMsg = "{\"input\":{\"userid\":\"10001\",\"passwd\":\"e10adc3949ba59abbe56e057f20f883e\",\"ischck\":\"false\"},\"comm_req\":{\"mntrsq\":\"1\",\"corpno\":\"\",\"tranus\":\"10001\",\"tranbr\":\"\",\"servtp\":\"MGR\",\"pkgdes\":\"\"},\"sys\":{\"prcscd\":\"resets\"}}";
		// 自动生成交易流水
		reqData.put(Constants.TRANSQ, 1);
		// 自动生成交易日期
		reqData.put(Constants.TRANDT, DateTool.getNow(DateTool.YYYYMMDD));
		// 自动生成交易时间
		reqData.put(Constants.TRANTM, DateTool.getNow(DateTool.HHMMSS));
		// 交易处理码
		reqData.put(Constants.PRCSCD, "resets");
		try {
			// 请求数据字符集转换
			byte[] sendBody = sendBodyMsg.getBytes("UTF-8");
			System.out.println("=1=============sendBody==" + new String(sendBody));
			// 增加报文头
			String sendHeadMsg = getHeadMsg(sendBody.length, msg, reqData);
			System.out.println("=2=============sendHeadMsg==" + sendHeadMsg);
			byte[] sendHead = sendHeadMsg.getBytes("UTF-8");
			System.out.println("=3=============sendHead==" + new String(sendHead));
			// 将报文头和报文体拷贝到发送数组中
			byte[] sendMsg = new byte[sendBody.length + msg.getHeadLength()];
			System.out.println("=4=============sendMsg==" + new String(sendMsg));
			System.arraycopy(sendHead, 0, sendMsg, 0, msg.getHeadLength());
			System.out.println("=5=============sendMsg==" + new String(sendMsg));
			System.arraycopy(sendBody, 0, sendMsg, msg.getHeadLength(), sendBody.length);
			System.out.println("=6=============sendMsg==" + new String(sendMsg));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	private String getHeadMsg(int bodyLenth, ApSysMsg msg, Map<String, Object> reqData) {
		// 报文头长度
		int headLength = msg.getHeadLength();
		int msgLength = 0;
		// 报文长度定义
		String msgLen = msg.getMsgLen();
		if ("1".equals(msgLen)) {
			// 报文体
			msgLength = bodyLenth;
		} else if ("2".equals(msgLen)) {
			// 报文体+报文头
			msgLength = headLength + bodyLenth;
		} else {
			throw new SumpException("1203", "报文长度定义参数未实现" + msgLen);
		}
		reqData.put(Constants.HEADLN, msgLength);
		//msg.getHeadMsg() to msg.getMsgCd() 20181015

		ApSysMsg headMsg = apSysMsgRepository.findOne(msg.getMsgCd());

		
		String str = message.encap(headMsg.getMsgDefine(), msg.getMsgCd(), reqData);
		return str;
	}
}
