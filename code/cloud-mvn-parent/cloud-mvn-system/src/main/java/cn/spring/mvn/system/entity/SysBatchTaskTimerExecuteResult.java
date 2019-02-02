package cn.spring.mvn.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年6月1日 下午11:57:29
 * @ClassName: SystemBatchTimeTaskResult 
 * @Description: 任务调度(执行)结果
 */
@Entity
@Table(name = "sys_batch_task_timer_execute_result")
public class SysBatchTaskTimerExecuteResult implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 6075455766727397252L;
	
	@Id
	@Column(name = "JOB_NUMBER", nullable = false, length = 24)
	private String jobNumber;//任务执行编号
	@Column(name = "JOB_NAME", length = 24)
	private String jobName;//任务名称
	@Id
	@Column(name = "JOB_GROUP_NUMBER", nullable = false, length = 24)
	private String jobGroupNumber;//批量任务组批次号 
	@Column(name = "JOB_GROUP_NAME", length = 24)
	private String jobGroupName;//批量任务组名称
	@Column(name = "JOB_EXECUTE_DATE", nullable = false)
	private Date jobExecuteDate;//任务调度(执行)日期
	@Column(name = "JOB_EXECUTE_MESSAGE", length = 255)
	private String jobExecuteMessage;//任务调度(执行)信息
	@Column(name = "JOB_EXECUTE_STATUS", length = 255)
	private String jobExecuteStatus;//任务调度(执行)状态(SUCCESS/ERROR)
	@Id
	@Column(name = "JOB_EXECUTE_TIMESTAMP", length = 255)
	private String jobExecuteTimestamp;//任务调度(执行)时间戳
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroupNumber() {
		return jobGroupNumber;
	}
	public void setJobGroupNumber(String jobGroupNumber) {
		this.jobGroupNumber = jobGroupNumber;
	}
	public String getJobGroupName() {
		return jobGroupName;
	}
	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}
	public Date getJobExecuteDate() {
		return jobExecuteDate;
	}
	public void setJobExecuteDate(Date jobExecuteDate) {
		this.jobExecuteDate = jobExecuteDate;
	}
	public String getJobExecuteMessage() {
		return jobExecuteMessage;
	}
	public void setJobExecuteMessage(String jobExecuteMessage) {
		this.jobExecuteMessage = jobExecuteMessage;
	}
	public String getJobExecuteStatus() {
		return jobExecuteStatus;
	}
	public void setJobExecuteStatus(String jobExecuteStatus) {
		this.jobExecuteStatus = jobExecuteStatus;
	}
	public String getJobExecuteTimestamp() {
		return jobExecuteTimestamp;
	}
	public void setJobExecuteTimestamp(String jobExecuteTimestamp) {
		this.jobExecuteTimestamp = jobExecuteTimestamp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jobExecuteDate == null) ? 0 : jobExecuteDate.hashCode());
		result = prime
				* result
				+ ((jobExecuteMessage == null) ? 0 : jobExecuteMessage
						.hashCode());
		result = prime
				* result
				+ ((jobExecuteStatus == null) ? 0 : jobExecuteStatus.hashCode());
		result = prime
				* result
				+ ((jobExecuteTimestamp == null) ? 0 : jobExecuteTimestamp
						.hashCode());
		result = prime * result
				+ ((jobGroupName == null) ? 0 : jobGroupName.hashCode());
		result = prime * result
				+ ((jobGroupNumber == null) ? 0 : jobGroupNumber.hashCode());
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result
				+ ((jobNumber == null) ? 0 : jobNumber.hashCode());
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
		SysBatchTaskTimerExecuteResult other = (SysBatchTaskTimerExecuteResult) obj;
		if (jobExecuteDate == null) {
			if (other.jobExecuteDate != null)
				return false;
		} else if (!jobExecuteDate.equals(other.jobExecuteDate))
			return false;
		if (jobExecuteMessage == null) {
			if (other.jobExecuteMessage != null)
				return false;
		} else if (!jobExecuteMessage.equals(other.jobExecuteMessage))
			return false;
		if (jobExecuteStatus == null) {
			if (other.jobExecuteStatus != null)
				return false;
		} else if (!jobExecuteStatus.equals(other.jobExecuteStatus))
			return false;
		if (jobExecuteTimestamp == null) {
			if (other.jobExecuteTimestamp != null)
				return false;
		} else if (!jobExecuteTimestamp.equals(other.jobExecuteTimestamp))
			return false;
		if (jobGroupName == null) {
			if (other.jobGroupName != null)
				return false;
		} else if (!jobGroupName.equals(other.jobGroupName))
			return false;
		if (jobGroupNumber == null) {
			if (other.jobGroupNumber != null)
				return false;
		} else if (!jobGroupNumber.equals(other.jobGroupNumber))
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (jobNumber == null) {
			if (other.jobNumber != null)
				return false;
		} else if (!jobNumber.equals(other.jobNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SysBatchTaskTimerExecuteResult [jobNumber=" + jobNumber
				+ ", jobName=" + jobName + ", jobGroupNumber=" + jobGroupNumber
				+ ", jobGroupName=" + jobGroupName + ", jobExecuteDate="
				+ jobExecuteDate + ", jobExecuteMessage=" + jobExecuteMessage
				+ ", jobExecuteStatus=" + jobExecuteStatus
				+ ", jobExecuteTimestamp=" + jobExecuteTimestamp + "]";
	}
	
}
