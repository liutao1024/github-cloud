package cn.spring.mvn.client.com.client.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.spring.mvn.client.basic.exception.SumpException;
import cn.spring.mvn.client.com.client.Connector;
import cn.spring.mvn.client.com.client.Constants;
import cn.spring.mvn.client.com.client.Message;
import cn.spring.mvn.client.com.model.ApSysMsg;
import cn.spring.mvn.client.com.model.ApSysServs;
import cn.spring.mvn.client.com.model.repository.ApSysMsgRepository;

@Service("SocketConnectorImpl")
public class SocketConnectorImpl implements Connector {
	private static Logger logger = LoggerFactory.getLogger(SocketConnectorImpl.class);
	//超时时间
	private final static int TIMEOUT = 10000;
	private final static int SO_RCVBUF = 40980;
	
	@Resource
	private ApSysMsgRepository apSysMsgRepository;
	
	@Resource
	private Message message;

	@Override
	public String communication(byte[] sendMsg, ApSysServs apSysServs) {
		Socket socket = null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			socket = new Socket(apSysServs.getServiceIp(), apSysServs.getServicePort());
			//反馈报文
			String requestStr = new String(sendMsg);//requestJsonObject.toString();
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, apSysServs.getEncode()));
			bufferedWriter.write(requestStr);
			bufferedWriter.flush();
			socket.shutdownOutput();
			//读取服务器端响应字符串返回  
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, apSysServs.getEncode()));
			String responseStr = bufferedReader.readLine();
			socket.close();
			return responseStr;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw new SumpException("1110", "未知主机");
		} catch (IOException e) {
			e.printStackTrace();
			throw new SumpException("1120", "通讯超时");
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	/**
	 * 原来的处理
	 */
	@Override
	public Map<String, Object> sendMsg(byte[] sendBuffer, String rspMsgCd, ApSysServs apSysServs) {
		Socket sock = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			sock = new Socket();
			sock.connect(new InetSocketAddress(apSysServs.getServiceIp(), apSysServs.getServicePort()));
			// 设置InputStream上调用 read()阻塞超时时间5秒
			sock.setSoTimeout(TIMEOUT);
			sock.setReceiveBufferSize(SO_RCVBUF);
			// 关闭Nagle算法.立即发包
			sock.setTcpNoDelay(true);
			// 发送数据 
			os = sock.getOutputStream();
			os.write(sendBuffer);
			os.flush();
			// 接收数据 
			is = sock.getInputStream();
			
			//反馈报文
			logger.debug("======rspMsgCd=======" + rspMsgCd);
			ApSysMsg msg = apSysMsgRepository.findOne(rspMsgCd);
			logger.debug("======msg=======" + msg);
			//处理反馈报文头
			byte[] recvHeadBuffer = new byte[msg.getHeadLength()];
			is.read(recvHeadBuffer);

			String recvHeadMsg = new String(recvHeadBuffer, apSysServs.getEncode());

			ApSysMsg headMsg = apSysMsgRepository.findOne(msg.getHeadMsg());
			Map<String, Object> rspData = message.unencap(headMsg.getMsgDefine(), msg.getHeadMsg(), recvHeadMsg);

			//处理反馈报文体
			int msgLen = Integer.valueOf(rspData.get(Constants.HEADLN).toString());
			int bodyLen = 0;
			//报文长度定义
			String msgBodyLen = msg.getMsgLen();
			if("1".equals(msgBodyLen)){
				//报文体
				bodyLen = msgLen;
			}else if("2".equals(msgBodyLen)){
				//报文体+报文头
				bodyLen = msgLen - msg.getHeadLength();
			}else{
				throw new SumpException("1203","报文长度定义参数未实现" + msgBodyLen);
			}

			byte[] recvBodyBuffer = new byte[bodyLen];

			is.read(recvBodyBuffer);
			
			logger.info("反馈报文长度=================" + recvBodyBuffer.length);
			String recvBodyMsg = new String(recvBodyBuffer, apSysServs.getEncode());

			logger.info("反馈报文=================" + recvBodyMsg);
			Map<String, Object> rspBodyData = message.unencap(msg.getMsgDefine(), rspMsgCd, recvBodyMsg);

			//返回数据
			rspData.putAll(rspBodyData);

			return rspData;
		} catch (UnknownHostException e) {
			//e.printStackTrace();
			throw new SumpException("1110", "未知主机");
		} catch (IOException e) {
			//e.printStackTrace();
			throw new SumpException("1120", "通讯超时");
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (sock != null) {
				try {
					sock.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}
}