package cn.spring.mvn.client.model.primarykey;

import java.io.Serializable;

public class ApSysColumnPK implements Serializable{

	private static final long serialVersionUID = -1858432441320264585L;

	private String msgCd;
	
	private String columnCd;

	public String getMsgCd() {
		return msgCd;
	}

	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}

	public String getColumnCd() {
		return columnCd;
	}

	public void setColumnCd(String columnCd) {
		this.columnCd = columnCd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((columnCd == null) ? 0 : columnCd.hashCode());
		result = prime * result + ((msgCd == null) ? 0 : msgCd.hashCode());
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
		ApSysColumnPK other = (ApSysColumnPK) obj;
		if (columnCd == null) {
			if (other.columnCd != null)
				return false;
		} else if (!columnCd.equals(other.columnCd))
			return false;
		if (msgCd == null) {
			if (other.msgCd != null)
				return false;
		} else if (!msgCd.equals(other.msgCd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApSysColumnPK [msgCd=" + msgCd + ", columnCd=" + columnCd + "]";
	}
	
}
