package cn.spring.mvn.client.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.spring.mvn.basic.exception.SumpException;
import cn.spring.mvn.socket.utils.FileUtil;
import cn.spring.mvn.client.Client;
import cn.spring.mvn.client.Connector;
import cn.spring.mvn.client.Constants;
import cn.spring.mvn.client.DataWriter;
import cn.spring.mvn.client.Message;
import cn.spring.mvn.client.model.ApSysEncap;
import cn.spring.mvn.client.model.ApSysMsg;
import cn.spring.mvn.client.model.ApSysServs;
import cn.spring.mvn.client.model.ApSysTrans;
import cn.spring.mvn.client.model.repository.ApSysEncapRepository;
import cn.spring.mvn.client.model.repository.ApSysMsgRepository;
import cn.spring.mvn.client.model.repository.ApSysServsRepository;
import cn.spring.mvn.client.model.repository.ApSysTransRepository;
import cn.spring.mvn.comm.tools.DateTool;
import cn.spring.mvn.comm.tools.MD5Tool;
import cn.spring.mvn.comm.util.CommUtil;

/**
 * 1.请求报文格式为:
 * 	{
 * 		"sys_req":{
 * 					"servtp":"MGR",
 * 					"servno":"02",
 * 					"servdt":"20181016",
 * 					"servtm":"20:49:32:42",
 * 					"servsq":"201810161120398",
 * 					"tranbr":"01",
 * 					"tranus":"10001",
 * 					"trandt":"",
 * 					"trantm":"",
 * 					"transq":"",
 * 					"status":"",
 * 					"retcod":"",
 * 					"retmsg":""
 * 			  },
 * 		"comm_req":{
 * 					"corpno":"001",
 * 					"prcscd":"qrcust"
 * 				},
 * 		"input":{
 * 					"custno":"",
 * 					"custna":"刘涛"
 * 				}
 * 		
 * 	}
 * sys_reqp和comm_req中的字段固定,接口内容一般放在input中
 * 
 * 2.响应报文的格式为:
 * (查询类)
 * {
 * 		"sys_rsp":{
 * 					"servtp":"MGR",
 * 					"servno":"02",
 * 					"servdt":"20181016",
 * 					"servtm":"20:49:32:42",
 * 					"servsq":"201810161120398",
 * 					"tranbr":"01",
 * 					"tranus":"10001",
 * 					"trandt":"20181016",
 * 					"trantm":"20:49:33:42",
 * 					"transq":"0bfc22b296224axaa7b11fe7036a7c61",
 * 					"status":"SUCCUS",(ERROR)
 * 					"mesage":""
 * 			  	},
 * 		"comm_rsp":{
 * 					"corpno":"001",
 * 					"prcscd":"qrcust"
 * 				},
 * 		"output":{
 * 					"count":"4",
 * 					"infos":[
 *						      {"custna":"刘德华","custno":"201110241001","idtfno":"511024199112030398","idtftp":"SFZ","email":""},
 *			 				  {"custna":"张家辉","custno":"201110241002","idtfno":"511024198612030398","idtftp":"SFZ","email":""},
 *			 				  {"custna":"陈小春","custno":"201110241003","idtfno":"511024198512030398","idtftp":"SFZ","email":""},
 *			 				  {"custna":"古天乐","custno":"201110241004","idtfno":"511024198812030398","idtftp":"SFZ","email":""}
 *							]
 * 				},
 * 		"retCode":"0000",
 * 		"retMsg":""
 * }
 * (执行类)
 * {
 * 		"sys_rsp":{
 * 					"servtp":"MGR",
 * 					"servno":"02",
 * 					"servdt":"20181016",
 * 					"servtm":"20:49:32:42",
 * 					"servsq":"201810161120398",
 * 					"tranbr":"01",
 * 					"tranus":"10001",
 * 					"trandt":"20181016",
 * 					"trantm":"20:49:33:42",
 * 					"transq":"0bfc22b296224axaa7b11fe7036a7c61",
 * 					"status":"SUCCUS",(ERROR)
 * 					"mesage":"执行成功"
 * 			  	},
 * 		"comm_rsp":{
 * 					"corpno":"001",
 * 					"prcscd":"opcust"
 * 				},
 * 		"output":{
 * 					"opendt":"20181016",
 * 					"opensq":"0bfc22b296224axaa7b11fe7036a7c61",
 * 					"custno":"6010000123",
 * 					"trandt":"20181016"
 * 				},
 * 		"retCode":"0000",
 * 		"retMsg":""
 * }
 * sys_rsp和comm_rsp中的字段固定,接口字段在output
 */
@Service("ClientImpl")
public class ClientImpl implements Client {
	private static Logger logger = LoggerFactory.getLogger(ClientImpl.class);
	private final static String SUCCESS = "SUCCESS";

	@Resource
	private ApSysTransRepository apSysTransRepository;

	@Resource
	private ApSysServsRepository apSysServsRepository;

	@Resource
	private ApSysEncapRepository apSysEncapRepository;

	@Resource
	private ApSysMsgRepository apSysMsgRepository;

	@Resource
	private Message message;

	@Resource
	private Connector tcpSocket;
	
	@Override
	public Map<String, Object> callClient(String prcscd, Map<String, Object> reqData) {
		Map<String, Object> rspData = new ConcurrentHashMap<String, Object>();
		// 交易码不能为空
		if (CommUtil.isNull(prcscd)){
			throw new SumpException("1100", "交易码不能为空");
		}
		ApSysTrans apSysTrans = apSysTransRepository.findOne(prcscd);
		// 判断交易接口状态,如果无效就直接返回成功
		if (CommUtil.isNull(apSysTrans) || "N".equals(apSysTrans.getTransStatus())) {
			rspData.put("retCode", "0000");//使程序通过
			rspData.put("retMsg", "接口关闭!");
			return rspData;
		}
		/**
		 *  (1)设置comm_req中的内容
		 */
		// 法人代码
		reqData.put(Constants.CORPNO, CommUtil.getObject(reqData.get(Constants.CORPNO), ""));
		// 交易处理码
		reqData.put(Constants.PRCSCD, prcscd);
		/**
		 * (2)设置sys_req中的内容
		 */
		/*
		 * 1.渠道系统
		 */
		// 交易渠道类型
		reqData.put(Constants.SERVTP, CommUtil.getObject(reqData.get(Constants.SERVTP), ""));//
		// 交易渠道号
		reqData.put(Constants.SERVNO, CommUtil.getObject(reqData.get(Constants.SERVNO), ""));
		// 交易渠道日期
		reqData.put(Constants.SERVDT, CommUtil.getObject(reqData.get(Constants.SERVDT), DateTool.getNow(DateTool.YYYYMMDD)));
		// 交易渠道时间
		reqData.put(Constants.SERVTM, CommUtil.getObject(reqData.get(Constants.SERVTM), DateTool.getNow(DateTool.HHMMSS)));
		// 交易渠道流水
		reqData.put(Constants.SERVSQ, CommUtil.getObject(reqData.get(Constants.SERVSQ), MD5Tool.getSerial()));
		/*
		 * 2.核心系统
		 * 		按理说以下字段均为空
		 */
		// 交易机构
		reqData.put(Constants.TRANBR, CommUtil.getObject(reqData.get(Constants.TRANBR), ""));
		// 交易柜员
		reqData.put(Constants.TRANUS, CommUtil.getObject(reqData.get("userid"), ""));
		// 交易日期
		reqData.put(Constants.TRANDT, CommUtil.getObject(reqData.get(Constants.TRANSQ), ""));
		// 交易时间
		reqData.put(Constants.TRANTM, CommUtil.getObject(reqData.get(Constants.TRANSQ), ""));
		// 交易流水
		reqData.put(Constants.TRANSQ, CommUtil.getObject(reqData.get(Constants.TRANSQ), ""));
		// 交易状态
		reqData.put(Constants.STATUS, CommUtil.getObject(reqData.get(Constants.STATUS), ""));
		// 交易信息
		reqData.put(Constants.MESAGE, CommUtil.getObject(reqData.get(Constants.MESAGE), ""));
		
		/**
		 * 转换请求报文
		 */
		ApSysEncap apSysEncap = apSysEncapRepository.findOne(apSysTrans.getEncapCd());
		ApSysMsg reqApSysMsg = apSysMsgRepository.findOne(apSysEncap.getReqMsg());

		// 封装发送报文
		String reqMsg = message.encap(reqApSysMsg.getMsgDefine(), apSysEncap.getReqMsg(), reqData);

		logger.debug("请求报文==============" + reqMsg);
		/**
		 * 调用通讯客户端
		 */
		ApSysServs apSysServs = apSysServsRepository.findOne(apSysTrans.getServiceCd());
		try {
			// 请求数据字符集转换
			byte[] sendMsg = reqMsg.getBytes(apSysServs.getEncode());
			// 调用服务
			Connector connector = null;
			
			switch (apSysServs.getServiceType()) {
			case "1":
				// Socket通讯
				connector = tcpSocket;
				break;
//			case "2":
				// HTTP 暂无
//				connector = tcpHttp;
//				break;
			default:
				throw new SumpException("1130", "暂不支持的服务类型" + apSysServs.getServiceType());
			}
			//调用连接器的communication方法,并接收返回
			String rspMsg = connector.communication(sendMsg, apSysServs);
			/**
			 * 响应报文处理
			 * 	(处理服务器端返回的字符串)
			 */
			ApSysMsg rspApSysMsg = apSysMsgRepository.findOne(apSysEncap.getRspMsg());
			rspData = message.unencap(rspApSysMsg.getMsgDefine(), rspApSysMsg.getMsgCd(), rspMsg);
			//根据sys_rsp中的status+mesage判断出retCode和retMsg   20181016 21:18
			String status = (String) rspData.get(Constants.STATUS);
			String mesage = (String) rspData.get(Constants.MESAGE);
			if(!SUCCESS.equals(status)){
				rspData.put(Constants.ERRORCD, mesage);//这儿的mesage应该包含有错误编码+错误信息
				rspData.put(Constants.ERRMSG, mesage);
			}else {
				rspData.put(Constants.ERRORCD, "0000");
			}
			//统一处理错误码,0000或空转换成0000为正确码
			String errorcd = rspData.get(Constants.ERRORCD).toString();
			if("0000".equals(errorcd) || CommUtil.isNull(errorcd)) {
				rspData.put(Constants.ERRORCD, "0000");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new SumpException("1130", "不支持的字符集" + apSysServs.getEncode());
		}
		logger.info("反馈报文==============" + rspData);
		return rspData;
	}

	/**
	 * 封装报文头
	 * @param bodyLenth 报文体长度
	 * @param msg 请求报文定义
	 * @param reqData 请求数据
	 * @return 返回报文头信息
	 */
	public String getHeadMsg(int bodyLenth, ApSysMsg msg, Map<String, Object> reqData) {
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
		logger.debug("======headMsg======" + msg.getMsgCd());

		ApSysMsg headMsg = apSysMsgRepository.findOne(msg.getMsgCd());

		logger.debug("======msgDefine======" + headMsg.getMsgDefine());
		
		String str = message.encap(headMsg.getMsgDefine(), msg.getMsgCd(), reqData);
		return str;
	}

	@Override
	@Transactional
	public void readFile(String prcscd, DataWriter w,String inputDate) {
		// 交易码不能为空
		if (StringUtils.isEmpty(prcscd)){
			throw new SumpException("1100", "交易码不能为空");
		}

		ApSysTrans trans = apSysTransRepository.findOne(prcscd);

		// 判断交易接口状态,如果无效就直接返回成功
		if ("N".equals(trans.getTransStatus())) {
			return;
		}
		StringBuilder fileName = new StringBuilder()
				.append(specialCharater(trans.getFilePrefix(),inputDate)).append(prcscd)
				.append(specialCharater(trans.getFileSufix(),inputDate)).append(trans.getFileType());

		// 获取远程文件
		ApSysServs serv = apSysServsRepository.findOne(trans.getServiceCd());
		remoteFile(serv, "D", trans.getFilePath(), fileName.toString());

		// 处理文件数据
		if(trans.getBeginLine() == null){
			trans.setBeginLine(1);//默认从第二行开始
		}
		FileUtil file = new FileUtil(fileName.toString(), trans.getFilePath(),
				trans.getFileSplit(),serv.getEncode(),trans.getDealCnt(),trans.getCalFlag(),trans.getCalCharAt(),trans.getBeginLine());
		file.readFile(w,inputDate);

	}

	/**
	 * 处理远程文件
	 * @param serv 服务参数
	 * @param oper 操作码
	 * @param basePath 本地路径
	 * @param fileName 文件名称
	 */
	private void remoteFile(ApSysServs serv, String oper, String basePath,
			String fileName) {
		if ("2".equals(serv.getServiceType())) {
			// 本地服务,文件直接在本地不用去远程下载和上传
			return;
		} else if ("3".equals(serv.getServiceType())) {
			// ftp协议
		} else if ("4".equals(serv.getServiceType())) {
			// sftp协议

		}

		if ("U".equals(oper)) {
			// 上传文件

		} else if ("D".equals(oper)) {
			// 下载文件

		} else {
			logger.error("远程文件处理操作方法未知" + oper);
			throw new SumpException("1104", "远程文件处理操作方法未知" + oper);
		}
	}
	
	/**
	 * 处理特殊含义字符
	 * @param special 特殊字符
	 * @return 返回字符
	 * 
	 * 如果没有匹配到特殊字符就原值返回
	 */
	private String specialCharater(String special,String inputDate){
		
		String specialCharater = special;
		
		if(StringUtils.isEmpty(specialCharater))
			return "";
		
		if("date8bit".equals(special)){
			specialCharater = DateTool.getNow(DateTool.YYYYMMDD);
		}else if("dateinput".equals(special)){
			specialCharater = inputDate;
		}
			
		return specialCharater;
			 
	}
}
