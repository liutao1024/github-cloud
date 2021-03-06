package cn.spring.mvn.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sys_transaction")
public class SysTransaction implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 2728752695162080006L;
	
	@Id
	@Column(name = "transactionCode", nullable = false, length = 24)
	private String corecd;//trancd交易码
	@Column(name = "transactionType", nullable = false, length = 24)
	private String trantp;//交易类型 Q-查询,D-执行
	@Column(name = "transactionName", length = 24)
	private String tranna;//交易名称
	@Column(name = "transactionPath", length = 100)
	private String path;//代码路径(cn.spring.mvn...)主要是输入输出类的路径
	@Column(name = "transactionModule", length = 36)
	private String module;//代码模块 目前只有core/core.account(账户)/core.deposit(存款)/core.fund(基金)/core.loan(贷款)
	@Column(name = "transactionClass", length = 36)
	private String eclass;//具体的实现类execute class
	@Column(name = "transactionMethod", length = 36)
	private String method;//执行的方法
	@Column(name = "transactionMark", length = 36)
	private String runmak;//运行标志run mark
	public String getCorecd() {
		return corecd;
	}
	public void setCorecd(String corecd) {
		this.corecd = corecd;
	}
	public String getTrantp() {
		return trantp;
	}
	public void setTrantp(String trantp) {
		this.trantp = trantp;
	}
	public String getTranna() {
		return tranna;
	}
	public void setTranna(String tranna) {
		this.tranna = tranna;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getEclass() {
		return eclass;
	}
	public void setEclass(String eclass) {
		this.eclass = eclass;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getRunmak() {
		return runmak;
	}
	public void setRunmak(String runmak) {
		this.runmak = runmak;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corecd == null) ? 0 : corecd.hashCode());
		result = prime * result + ((eclass == null) ? 0 : eclass.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((runmak == null) ? 0 : runmak.hashCode());
		result = prime * result + ((tranna == null) ? 0 : tranna.hashCode());
		result = prime * result + ((trantp == null) ? 0 : trantp.hashCode());
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
		SysTransaction other = (SysTransaction) obj;
		if (corecd == null) {
			if (other.corecd != null)
				return false;
		} else if (!corecd.equals(other.corecd))
			return false;
		if (eclass == null) {
			if (other.eclass != null)
				return false;
		} else if (!eclass.equals(other.eclass))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (runmak == null) {
			if (other.runmak != null)
				return false;
		} else if (!runmak.equals(other.runmak))
			return false;
		if (tranna == null) {
			if (other.tranna != null)
				return false;
		} else if (!tranna.equals(other.tranna))
			return false;
		if (trantp == null) {
			if (other.trantp != null)
				return false;
		} else if (!trantp.equals(other.trantp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SysTransaction [corecd=" + corecd + ", trantp=" + trantp
				+ ", tranna=" + tranna + ", path=" + path + ", module="
				+ module + ", eclass=" + eclass + ", method=" + method
				+ ", runmak=" + runmak + "]";
	}
}
