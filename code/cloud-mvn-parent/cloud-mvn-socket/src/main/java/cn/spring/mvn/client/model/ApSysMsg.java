package cn.spring.mvn.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * tableName : ap_sys_msg
 */
@Entity
@Table(name = "ap_sys_msg")
public class ApSysMsg implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 2661705002144053816L;

	@Id
	@Column(name = "msg_cd", length = 10)
	private String msgCd; // 报文格式编号

	@Column(name = "msg_remark", length = 100)
	private String msgRemark; // 报文格式说明

	@Column(name = "msg_define")
	private String msgDefine; // 格式定义

	@Column(name = "split_char", length = 5)
	private String splitChar; // 分隔符

	@Column(name = "head_length")
	private Integer headLength; // 报文头长度

	@Column(name = "head_msg", length = 100)
	private String headMsg; // 报文头格式定义

	@Column(name = "xml_coding", length = 10)
	private String xmlCoding; // XML字符集
	
	@Column(name="msg_len", length= 1)
	private String msgLen;

	public String getMsgLen() {
		return msgLen;
	}

	public void setMsgLen(String msgLen) {
		this.msgLen = msgLen;
	}

	public String getMsgCd() {
		return msgCd;
	}

	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}

	public String getMsgRemark() {
		return msgRemark;
	}

	public void setMsgRemark(String msgRemark) {
		this.msgRemark = msgRemark;
	}

	public String getMsgDefine() {
		return msgDefine;
	}

	public void setMsgDefine(String msgDefine) {
		this.msgDefine = msgDefine;
	}

	public String getSplitChar() {
		return splitChar;
	}

	public void setSplitChar(String splitChar) {
		this.splitChar = splitChar;
	}

	public Integer getHeadLength() {
		return headLength;
	}

	public void setHeadLength(Integer headLength) {
		this.headLength = headLength;
	}

	public String getHeadMsg() {
		return headMsg;
	}

	public void setHeadMsg(String headMsg) {
		this.headMsg = headMsg;
	}

	public String getXmlCoding() {
		return xmlCoding;
	}

	public void setXmlCoding(String xmlCoding) {
		this.xmlCoding = xmlCoding;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((headLength == null) ? 0 : headLength.hashCode());
		result = prime * result + ((headMsg == null) ? 0 : headMsg.hashCode());
		result = prime * result + ((msgCd == null) ? 0 : msgCd.hashCode());
		result = prime * result
				+ ((msgDefine == null) ? 0 : msgDefine.hashCode());
		result = prime * result + ((msgLen == null) ? 0 : msgLen.hashCode());
		result = prime * result
				+ ((msgRemark == null) ? 0 : msgRemark.hashCode());
		result = prime * result
				+ ((splitChar == null) ? 0 : splitChar.hashCode());
		result = prime * result
				+ ((xmlCoding == null) ? 0 : xmlCoding.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApSysMsg other = (ApSysMsg) obj;
		if (headLength == null) {
			if (other.headLength != null)
				return false;
		} else if (!headLength.equals(other.headLength))
			return false;
		if (headMsg == null) {
			if (other.headMsg != null)
				return false;
		} else if (!headMsg.equals(other.headMsg))
			return false;
		if (msgCd == null) {
			if (other.msgCd != null)
				return false;
		} else if (!msgCd.equals(other.msgCd))
			return false;
		if (msgDefine == null) {
			if (other.msgDefine != null)
				return false;
		} else if (!msgDefine.equals(other.msgDefine))
			return false;
		if (msgLen == null) {
			if (other.msgLen != null)
				return false;
		} else if (!msgLen.equals(other.msgLen))
			return false;
		if (msgRemark == null) {
			if (other.msgRemark != null)
				return false;
		} else if (!msgRemark.equals(other.msgRemark))
			return false;
		if (splitChar == null) {
			if (other.splitChar != null)
				return false;
		} else if (!splitChar.equals(other.splitChar))
			return false;
		if (xmlCoding == null) {
			if (other.xmlCoding != null)
				return false;
		} else if (!xmlCoding.equals(other.xmlCoding))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApSysMsg [msgCd=" + msgCd + ", msgRemark=" + msgRemark
				+ ", msgDefine=" + msgDefine + ", splitChar=" + splitChar
				+ ", headLength=" + headLength + ", headMsg=" + headMsg
				+ ", xmlCoding=" + xmlCoding + ", msgLen=" + msgLen + "]";
	}

}