package cn.spring.mvn.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * tableName : ap_sys_trans
 * 
 */
@Entity
@Table(name = "ap_sys_trans")
public class ApSysTrans {
	@Id
	@Column(name = "trans_cd", length = 10)
	private String transCd; // 交易标识号

	@Column(name = "trans_name", length = 50)
	private String transName;// 交易名称

	@Column(name = "service_cd", length = 10)
	private String serviceCd;// 发送服务号

	@Column(name = "encap_cd", length = 10)
	private String encapCd;// 报文封装编号

	@Column(name = "trans_status")
	private String transStatus;// 交易状态

	@Column(name = "file_path", length = 500)
	private String filePath;// 本地文件路径

	@Column(name = "file_type", length = 10)
	private String fileType; // 文件类型

	@Column(name = "file_prefix", length = 20)
	private String filePrefix;// 文件前缀
	
	@Column(name = "file_suffix", length = 20)
	private String fileSufix;// 文件后缀

	@Column(name = "file_split")
	private String fileSplit;// 文件分隔符
	
	@Column(name = "deal_cnt")
	private Integer dealCnt;// 一次处理数据笔数

	@Column(name = "cal_flag")
	private String calFlag;// 首行数据为统计笔数
	
	@Column(name = "cal_char_at")
	private Integer calCharAt;// 首行统计数据所在位置
	
	@Column(name = "begin_line")
	private Integer beginLine;// 明细开始行数
	
	public Integer getBeginLine() {
		return beginLine;
	}

	public void setBeginLine(Integer beginLine) {
		this.beginLine = beginLine;
	}

	public String getCalFlag() {
		return calFlag;
	}

	public Integer getCalCharAt() {
		return calCharAt;
	}

	public void setCalCharAt(Integer calCharAt) {
		this.calCharAt = calCharAt;
	}

	public void setCalFlag(String calFlag) {
		this.calFlag = calFlag;
	}

	public Integer getDealCnt() {
		return dealCnt;
	}

	public void setDealCnt(Integer dealCnt) {
		this.dealCnt = dealCnt;
	}

	public String getFileSufix() {
		return fileSufix;
	}

	public void setFileSufix(String fileSufix) {
		this.fileSufix = fileSufix;
	}

	public String getTransCd() {
		return transCd;
	}

	public void setTransCd(String transCd) {
		this.transCd = transCd;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public String getServiceCd() {
		return serviceCd;
	}

	public void setServiceCd(String serviceCd) {
		this.serviceCd = serviceCd;
	}

	public String getEncapCd() {
		return encapCd;
	}

	public void setEncapCd(String encapCd) {
		this.encapCd = encapCd;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getFileSplit() {
		return fileSplit;
	}

	public void setFileSplit(String fileSplit) {
		this.fileSplit = fileSplit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beginLine == null) ? 0 : beginLine.hashCode());
		result = prime * result
				+ ((calCharAt == null) ? 0 : calCharAt.hashCode());
		result = prime * result + ((calFlag == null) ? 0 : calFlag.hashCode());
		result = prime * result + ((dealCnt == null) ? 0 : dealCnt.hashCode());
		result = prime * result + ((encapCd == null) ? 0 : encapCd.hashCode());
		result = prime * result
				+ ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result
				+ ((filePrefix == null) ? 0 : filePrefix.hashCode());
		result = prime * result
				+ ((fileSplit == null) ? 0 : fileSplit.hashCode());
		result = prime * result
				+ ((fileSufix == null) ? 0 : fileSufix.hashCode());
		result = prime * result
				+ ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result
				+ ((serviceCd == null) ? 0 : serviceCd.hashCode());
		result = prime * result + ((transCd == null) ? 0 : transCd.hashCode());
		result = prime * result
				+ ((transName == null) ? 0 : transName.hashCode());
		result = prime * result
				+ ((transStatus == null) ? 0 : transStatus.hashCode());
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
		ApSysTrans other = (ApSysTrans) obj;
		if (beginLine == null) {
			if (other.beginLine != null)
				return false;
		} else if (!beginLine.equals(other.beginLine))
			return false;
		if (calCharAt == null) {
			if (other.calCharAt != null)
				return false;
		} else if (!calCharAt.equals(other.calCharAt))
			return false;
		if (calFlag == null) {
			if (other.calFlag != null)
				return false;
		} else if (!calFlag.equals(other.calFlag))
			return false;
		if (dealCnt == null) {
			if (other.dealCnt != null)
				return false;
		} else if (!dealCnt.equals(other.dealCnt))
			return false;
		if (encapCd == null) {
			if (other.encapCd != null)
				return false;
		} else if (!encapCd.equals(other.encapCd))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (filePrefix == null) {
			if (other.filePrefix != null)
				return false;
		} else if (!filePrefix.equals(other.filePrefix))
			return false;
		if (fileSplit == null) {
			if (other.fileSplit != null)
				return false;
		} else if (!fileSplit.equals(other.fileSplit))
			return false;
		if (fileSufix == null) {
			if (other.fileSufix != null)
				return false;
		} else if (!fileSufix.equals(other.fileSufix))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (serviceCd == null) {
			if (other.serviceCd != null)
				return false;
		} else if (!serviceCd.equals(other.serviceCd))
			return false;
		if (transCd == null) {
			if (other.transCd != null)
				return false;
		} else if (!transCd.equals(other.transCd))
			return false;
		if (transName == null) {
			if (other.transName != null)
				return false;
		} else if (!transName.equals(other.transName))
			return false;
		if (transStatus == null) {
			if (other.transStatus != null)
				return false;
		} else if (!transStatus.equals(other.transStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApSysTrans [transCd=" + transCd + ", transName=" + transName
				+ ", serviceCd=" + serviceCd + ", encapCd=" + encapCd
				+ ", transStatus=" + transStatus + ", filePath=" + filePath
				+ ", fileType=" + fileType + ", filePrefix=" + filePrefix
				+ ", fileSufix=" + fileSufix + ", fileSplit=" + fileSplit
				+ ", dealCnt=" + dealCnt + ", calFlag=" + calFlag
				+ ", calCharAt=" + calCharAt + ", beginLine=" + beginLine + "]";
	}

}