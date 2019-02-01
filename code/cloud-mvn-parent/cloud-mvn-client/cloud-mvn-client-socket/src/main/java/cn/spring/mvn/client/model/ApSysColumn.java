package cn.spring.mvn.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import cn.spring.mvn.client.model.primarykey.ApSysColumnPK;

/**
 * tableName : ap_sys_column
 */
@Entity
@IdClass(ApSysColumnPK.class)
@Table(name = "ap_sys_column")
public class ApSysColumn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1909948540002954866L;

	@Id
	@Column(name = "msg_cd", length = 10)
	private String msgCd;// 报文格式编号

	@Id
	@Column(name = "column_cd", length = 50)
	private String columnCd;// 字段号

	@Column(name = "column_name", length = 50)
	private String columnName;// 字段名称

	@Column(name = "column_length")
	private Integer columnLength;// 字段长度

	@Column(name = "column_mapping", length = 50)
	private String columnMapping;// 字段匹配号

	@Column(name = "column_type")
	private String columnType;// 字段类型

	@Column(name = "value_digit")
	private String valueDigit;// 数值进制

	@Column(name = "date_pattern")
	private String datePattern;// 日期格式

	@Column(name = "default_value", length = 50)
	private String defaultValue;// 默认值

	@Column(name = "cycling_flag")
	private String cyclingFlag;// 循环节点

	@Column(name = "sort_seq")
	private int sortSeq;// 排序

	@Column(name = "cycling_column", length = 50)
	private String cyclingColumn;// 循环字段

	@Column(name = "polish_type")
	private String polishType;// 补齐方式

	@Column(name = "polish_char", length = 10)
	private String polishChar;// 补齐填充字符

	
	public String getColumnCd() {
		return columnCd;
	}

	public void setColumnCd(String columnCd) {
		this.columnCd = columnCd;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}

	public String getColumnMapping() {
		return columnMapping;
	}

	public void setColumnMapping(String columnMapping) {
		this.columnMapping = columnMapping;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getValueDigit() {
		return valueDigit;
	}

	public void setValueDigit(String valueDigit) {
		this.valueDigit = valueDigit;
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getCyclingFlag() {
		return cyclingFlag;
	}

	public void setCyclingFlag(String cyclingFlag) {
		this.cyclingFlag = cyclingFlag;
	}

	public int getSortSeq() {
		return sortSeq;
	}

	public void setSortSeq(int sortSeq) {
		this.sortSeq = sortSeq;
	}

	public String getCyclingColumn() {
		return cyclingColumn;
	}

	public void setCyclingColumn(String cyclingColumn) {
		this.cyclingColumn = cyclingColumn;
	}

	public String getPolishType() {
		return polishType;
	}

	public void setPolishType(String polishType) {
		this.polishType = polishType;
	}

	public String getPolishChar() {
		return polishChar;
	}

	public void setPolishChar(String polishChar) {
		this.polishChar = polishChar;
	}

	public String getMsgCd() {
		return msgCd;
	}

	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((columnCd == null) ? 0 : columnCd.hashCode());
		result = prime * result
				+ ((columnLength == null) ? 0 : columnLength.hashCode());
		result = prime * result
				+ ((columnMapping == null) ? 0 : columnMapping.hashCode());
		result = prime * result
				+ ((columnName == null) ? 0 : columnName.hashCode());
		result = prime * result
				+ ((columnType == null) ? 0 : columnType.hashCode());
		result = prime * result
				+ ((cyclingColumn == null) ? 0 : cyclingColumn.hashCode());
		result = prime * result
				+ ((cyclingFlag == null) ? 0 : cyclingFlag.hashCode());
		result = prime * result
				+ ((datePattern == null) ? 0 : datePattern.hashCode());
		result = prime * result
				+ ((defaultValue == null) ? 0 : defaultValue.hashCode());
		result = prime * result + ((msgCd == null) ? 0 : msgCd.hashCode());
		result = prime * result
				+ ((polishChar == null) ? 0 : polishChar.hashCode());
		result = prime * result
				+ ((polishType == null) ? 0 : polishType.hashCode());
		result = prime * result + sortSeq;
		result = prime * result
				+ ((valueDigit == null) ? 0 : valueDigit.hashCode());
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
		ApSysColumn other = (ApSysColumn) obj;
		if (columnCd == null) {
			if (other.columnCd != null)
				return false;
		} else if (!columnCd.equals(other.columnCd))
			return false;
		if (columnLength == null) {
			if (other.columnLength != null)
				return false;
		} else if (!columnLength.equals(other.columnLength))
			return false;
		if (columnMapping == null) {
			if (other.columnMapping != null)
				return false;
		} else if (!columnMapping.equals(other.columnMapping))
			return false;
		if (columnName == null) {
			if (other.columnName != null)
				return false;
		} else if (!columnName.equals(other.columnName))
			return false;
		if (columnType == null) {
			if (other.columnType != null)
				return false;
		} else if (!columnType.equals(other.columnType))
			return false;
		if (cyclingColumn == null) {
			if (other.cyclingColumn != null)
				return false;
		} else if (!cyclingColumn.equals(other.cyclingColumn))
			return false;
		if (cyclingFlag == null) {
			if (other.cyclingFlag != null)
				return false;
		} else if (!cyclingFlag.equals(other.cyclingFlag))
			return false;
		if (datePattern == null) {
			if (other.datePattern != null)
				return false;
		} else if (!datePattern.equals(other.datePattern))
			return false;
		if (defaultValue == null) {
			if (other.defaultValue != null)
				return false;
		} else if (!defaultValue.equals(other.defaultValue))
			return false;
		if (msgCd == null) {
			if (other.msgCd != null)
				return false;
		} else if (!msgCd.equals(other.msgCd))
			return false;
		if (polishChar == null) {
			if (other.polishChar != null)
				return false;
		} else if (!polishChar.equals(other.polishChar))
			return false;
		if (polishType == null) {
			if (other.polishType != null)
				return false;
		} else if (!polishType.equals(other.polishType))
			return false;
		if (sortSeq != other.sortSeq)
			return false;
		if (valueDigit == null) {
			if (other.valueDigit != null)
				return false;
		} else if (!valueDigit.equals(other.valueDigit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApSysColumn [msgCd=" + msgCd + ", columnCd=" + columnCd
				+ ", columnName=" + columnName + ", columnLength="
				+ columnLength + ", columnMapping=" + columnMapping
				+ ", columnType=" + columnType + ", valueDigit=" + valueDigit
				+ ", datePattern=" + datePattern + ", defaultValue="
				+ defaultValue + ", cyclingFlag=" + cyclingFlag + ", sortSeq="
				+ sortSeq + ", cyclingColumn=" + cyclingColumn
				+ ", polishType=" + polishType + ", polishChar=" + polishChar
				+ "]";
	}
	
}