package cn.spring.mvn.client.web.model.primarykey;

import java.io.Serializable;

public class SifSysDictPK implements Serializable{

	private static final long serialVersionUID = -1858432441320264585L;

	private String dictType;
	
	private String dictId;

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dictId == null) ? 0 : dictId.hashCode());
		result = prime * result
				+ ((dictType == null) ? 0 : dictType.hashCode());
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
		SifSysDictPK other = (SifSysDictPK) obj;
		if (dictId == null) {
			if (other.dictId != null)
				return false;
		} else if (!dictId.equals(other.dictId))
			return false;
		if (dictType == null) {
			if (other.dictType != null)
				return false;
		} else if (!dictType.equals(other.dictType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApSysDictPK [dictType=" + dictType + ", dictId=" + dictId + "]";
	}
	
}
