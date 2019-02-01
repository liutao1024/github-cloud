package cn.spring.mvn.web.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spring.mvn.client.basic.exception.SumpException;
import cn.spring.mvn.client.basic.tools.DateTool;
import cn.spring.mvn.client.basic.utils.CommUtil;
import cn.spring.mvn.client.com.client.Constants;
import cn.spring.mvn.client.com.client.Message;
import cn.spring.mvn.client.com.model.ApSysMsg;
import cn.spring.mvn.client.com.model.repository.ApSysMsgRepository;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
public class NormalTest {
	@Autowired
	ApSysMsgRepository apSysMsgRepository;
	@Resource
	private Message message;
	
	@Test
	public void Test0003(){
		
		String str = new String();
		List<String> list = new ArrayList<String>();
		String[] arr = {};
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(StringUtils.isEmpty(str));
		System.out.println(CommUtil.isNull(str));
		System.out.println(list.size());
		System.out.println(CommUtil.isNull(list));
		System.out.println(CommUtil.isNull(arr));
		System.out.println(CommUtil.isNull(map));
		System.out.println(org.springframework.util.StringUtils.isEmpty(list));
	}
	
	@Test
	public void Test0002(){
		try {
//			String jsonStr = "{\"rqId\":\"8bfc22b296224bcaa7b11fe7036a7ce1\",\"status\":\"SUCCESS\",\"retCode\":\"0000\",\"retMsg\":\"NOERROR\",\"content\":{\"output\":{\"count\":\"3\",\"infos\":[{\"custna\":\"刘涛\",\"custno\":\"201110241001\",\"idtfno\":\"511024199112030398\"},{\"custna\":\"张家辉\",\"custno\":\"201110241001\",\"idtfno\":\"511024199112030398\"},{\"custna\":\"古天乐\",\"custno\":\"201110241001\",\"idtfno\":\"511024199112030398\"}]}}}";
			String jsonStr = "{\"rqId\":\"8bfc22b296224bcaa7b11fe7036a7ce1\",\"status\":\"SUCCESS\",\"retCode\":\"0000\",\"retMsg\":\"NOERROR\",\"content\":{\"output\":{\"count\":\"3\",\"infos\":[{\"custna\":\"刘涛\",\"custno\":\"201110241001\",\"idtfno\":\"511024199112030398\"},{\"custna\":\"张家辉\",\"custno\":\"201110241001\",\"idtfno\":\"511024199112030398\"},{\"custna\":\"古天乐\",\"custno\":\"201110241001\",\"idtfno\":\"511024199112030398\"}]}}}";
//			System.out.println(jsonStr);
			Map<String, Object> map1 = new ObjectMapper().readValue(jsonStr, Map.class);
			System.out.println(map1);
			Map<String, Object> map2 = JSONObject.parseObject(jsonStr, Map.class);
			System.out.println(map2);
			Object obj = map2.get("content");
			System.out.println(obj);
			String str = JSONObject.toJSONString(map1.get("content"));
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
			// 增加报文头
			String sendHeadMsg = getHeadMsg(sendBody.length, msg, reqData);
			byte[] sendHead = sendHeadMsg.getBytes("UTF-8");
			// 将报文头和报文体拷贝到发送数组中
			byte[] sendMsg = new byte[sendBody.length + msg.getHeadLength()];
			System.arraycopy(sendHead, 0, sendMsg, 0, msg.getHeadLength());
			System.arraycopy(sendBody, 0, sendMsg, msg.getHeadLength(), sendBody.length);
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
