package cn.spring.mvn.client;

/**
 * 报文常量字段
 */
public class Constants {
	/*
	 * comm 常量字段
	 */
	public final static String CORPNO = "corpno";// 法人代码
	public final static String PRCSCD = "prcscd";// 交易处理码
	
	/*
	 * sys 常量字段
	 */
	// 渠道系统部分
	public final static String SERVTP = "servtp";// 渠道类型
	public final static String SERVNO = "servno";// 渠道号
	public final static String SERVDT = "servdt";// 渠道日期
	public final static String SERVTM = "servtm";// 渠道时间
	public final static String SERVSQ = "servsq";// 渠道流水
	//核心系统部分
	public final static String TRANBR = "tranbr";// 交易机构
	public final static String TRANUS = "tranus";// 交易柜员
	public final static String TRANDT = "trandt";// 交易日期
	public final static String TRANTM = "trantm";// 交易时间
	public final static String TRANSQ = "transq";// 交易流水
	public final static String STATUS = "status";// 交易状态
	public final static String MESAGE = "mesage";// 交易信息
	
	/*
	 * 响应报文特有字段在Connector中根据sys中status以及mesage组装
	 */
	public final static String ERRORCD = "retCode";// 错误码
	public final static String ERRMSG = "retMsg";// 错误信息
	
	/*
	 * 原有未知作用字段
	 */
	public final static String HEADLN = "headln";// 报文头长度
	
	
	
}
