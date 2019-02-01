package cn.spring.mvn.client.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年10月11日 上午9:59:24
 * @ClassName: ApSysEncap 
 * @Description: tableName : ap_sys_encap
 */
@Entity
@Table(name = "ap_sys_encap")
public class ApSysEncap {

	// 报文封装编号
	@Id
	@Column(name = "encap_cd", length = 10)
	private String encapCd;

	// 封装说明
	@Column(name = "encap_remark", length = 100)
	private String encapRemark;

	// 请求报文
	@Column(name = "req_msg", length = 10)
	private String reqMsg;

	// 反馈报文
	@Column(name = "rsp_msg", length = 10)
	private String rspMsg;

	public String getEncapCd() {
		return encapCd;
	}

	public void setEncapCd(String encapCd) {
		this.encapCd = encapCd;
	}

	public String getEncapRemark() {
		return encapRemark;
	}

	public void setEncapRemark(String encapRemark) {
		this.encapRemark = encapRemark;
	}

	public String getReqMsg() {
		return reqMsg;
	}

	public void setReqMsg(String reqMsg) {
		this.reqMsg = reqMsg;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((encapCd == null) ? 0 : encapCd.hashCode());
		result = prime * result
				+ ((encapRemark == null) ? 0 : encapRemark.hashCode());
		result = prime * result + ((reqMsg == null) ? 0 : reqMsg.hashCode());
		result = prime * result + ((rspMsg == null) ? 0 : rspMsg.hashCode());
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
		ApSysEncap other = (ApSysEncap) obj;
		if (encapCd == null) {
			if (other.encapCd != null)
				return false;
		} else if (!encapCd.equals(other.encapCd))
			return false;
		if (encapRemark == null) {
			if (other.encapRemark != null)
				return false;
		} else if (!encapRemark.equals(other.encapRemark))
			return false;
		if (reqMsg == null) {
			if (other.reqMsg != null)
				return false;
		} else if (!reqMsg.equals(other.reqMsg))
			return false;
		if (rspMsg == null) {
			if (other.rspMsg != null)
				return false;
		} else if (!rspMsg.equals(other.rspMsg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApSysEncap [encapCd=" + encapCd + ", encapRemark="
				+ encapRemark + ", reqMsg=" + reqMsg + ", rspMsg=" + rspMsg
				+ "]";
	}

}