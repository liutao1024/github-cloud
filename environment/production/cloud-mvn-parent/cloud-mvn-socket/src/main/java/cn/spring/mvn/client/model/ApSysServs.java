package cn.spring.mvn.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年10月11日 上午10:20:47
 * @ClassName: ApSysServs
 * @Description: TODO(tableName : ap_sys_servs)
 */
@Entity
@Table(name = "ap_sys_servs")
public class ApSysServs {

	// 服务编号
	@Id
	@Column(name = "service_cd", length = 10)
	private String serviceCd;

	// 服务名称
	@Column(name = "service_name", length = 50)
	private String serviceName;

	// 服务类型
	@Column(name = "service_type")
	private String serviceType;

	// 服务IP
	@Column(name = "service_ip", length = 20)
	private String serviceIp;

	// 服务端口
	@Column(name = "service_port", length = 5)
	private Integer servicePort;

	// 字符集
	@Column(name = "encode", length = 10)
	private String encode;

	// 服务路径
	@Column(name = "file_path", length = 500)
	private String filePath;

	// 登陆用户名
	@Column(name = "login_user", length = 20)
	private String loginUser;

	// 登陆密码
	@Column(name = "login_passwd", length = 20)
	private String loginPasswd;
	

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getLoginPasswd() {
		return loginPasswd;
	}

	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}

	public String getServiceCd() {
		return serviceCd;
	}

	public void setServiceCd(String serviceCd) {
		this.serviceCd = serviceCd;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceIp() {
		return serviceIp;
	}

	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}

	public Integer getServicePort() {
		return servicePort;
	}

	public void setServicePort(Integer servicePort) {
		this.servicePort = servicePort;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((encode == null) ? 0 : encode.hashCode());
		result = prime * result
				+ ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result
				+ ((loginPasswd == null) ? 0 : loginPasswd.hashCode());
		result = prime * result
				+ ((loginUser == null) ? 0 : loginUser.hashCode());
		result = prime * result
				+ ((serviceCd == null) ? 0 : serviceCd.hashCode());
		result = prime * result
				+ ((serviceIp == null) ? 0 : serviceIp.hashCode());
		result = prime * result
				+ ((serviceName == null) ? 0 : serviceName.hashCode());
		result = prime * result
				+ ((servicePort == null) ? 0 : servicePort.hashCode());
		result = prime * result
				+ ((serviceType == null) ? 0 : serviceType.hashCode());
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
		ApSysServs other = (ApSysServs) obj;
		if (encode == null) {
			if (other.encode != null)
				return false;
		} else if (!encode.equals(other.encode))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (loginPasswd == null) {
			if (other.loginPasswd != null)
				return false;
		} else if (!loginPasswd.equals(other.loginPasswd))
			return false;
		if (loginUser == null) {
			if (other.loginUser != null)
				return false;
		} else if (!loginUser.equals(other.loginUser))
			return false;
		if (serviceCd == null) {
			if (other.serviceCd != null)
				return false;
		} else if (!serviceCd.equals(other.serviceCd))
			return false;
		if (serviceIp == null) {
			if (other.serviceIp != null)
				return false;
		} else if (!serviceIp.equals(other.serviceIp))
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		if (servicePort == null) {
			if (other.servicePort != null)
				return false;
		} else if (!servicePort.equals(other.servicePort))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApSysServs [serviceCd=" + serviceCd + ", serviceName="
				+ serviceName + ", serviceType=" + serviceType + ", serviceIp="
				+ serviceIp + ", servicePort=" + servicePort + ", encode="
				+ encode + ", filePath=" + filePath + ", loginUser="
				+ loginUser + ", loginPasswd=" + loginPasswd + "]";
	}
	
	
}