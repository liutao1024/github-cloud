package cn.spring.mvn.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LiuTao @date 2018年6月1日 下午11:29:08
 * @ClassName: SysBatchTaskControl 
 * @Description: 批量任务组控制器
 */
@Entity
@Table(name = "sys_batch_task_control")
public class SysBatchTaskControl implements Serializable{
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 5860649223007713622L;
	
	@Id
	@Column(name = "JOB_GROUP_NUMBER", nullable = false, length = 24)
	private String jobGroupNumber;//批量任务组批次号
	@Column(name = "JOB_GROUP_NAME", nullable = false, length = 24)
	private String jobGroupName;//批量任务组名称
	@Column(name = "JOB_GROUP_PERIOD_YEAR", nullable = false, length = 24)
	private String jobGroupPeriodYear;//调度周期--年份
	@Column(name = "JOB_GROUP_PERIOD_WEEK", nullable = false, length = 24)
	private String jobGroupPeriodWeek;//调度周期--周
	@Column(name = "JOB_GROUP_PERIOD_MONTH", nullable = false, length = 24)
	private String jobGroupPeriodMonth;//调度周期--月份
	@Column(name = "JOB_GROUP_PERIOD_DAY", nullable = false, length = 24)
	private String jobGroupPeriodDay;//调度周期--日
	@Column(name = "JOB_GROUP_PERIOD_HOUR", nullable = false, length = 24)
	private String jobGroupPeriodHour;//调度周期--小时
	@Column(name = "JOB_GROUP_PERIOD_MINUTE", nullable = false, length = 24)
	private String jobGroupPeriodMinute;//调度周期--分钟
	@Column(name = "JOB_GROUP_PERIOD_SECOND", nullable = false, length = 24)
	private String jobGroupPeriodSecond;//调度周期--秒钟
	@Column(name = "JOB_GROUP_DESCRIPTION", nullable = false, length = 24)
	private String jobGroupDescription;//批量任务组描述
	@Column(name = "JOB_GROUP_STATUS", nullable = false, length = 24)
	private String jobGroupStatus;//批量任务组状态(START/RUNING/STOP/STOPPED)
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
	public String getJobGroupPeriodYear() {
		return jobGroupPeriodYear;
	}
	public void setJobGroupPeriodYear(String jobGroupPeriodYear) {
		this.jobGroupPeriodYear = jobGroupPeriodYear;
	}
	public String getJobGroupPeriodWeek() {
		return jobGroupPeriodWeek;
	}
	public void setJobGroupPeriodWeek(String jobGroupPeriodWeek) {
		this.jobGroupPeriodWeek = jobGroupPeriodWeek;
	}
	public String getJobGroupPeriodMonth() {
		return jobGroupPeriodMonth;
	}
	public void setJobGroupPeriodMonth(String jobGroupPeriodMonth) {
		this.jobGroupPeriodMonth = jobGroupPeriodMonth;
	}
	public String getJobGroupPeriodDay() {
		return jobGroupPeriodDay;
	}
	public void setJobGroupPeriodDay(String jobGroupPeriodDay) {
		this.jobGroupPeriodDay = jobGroupPeriodDay;
	}
	public String getJobGroupPeriodHour() {
		return jobGroupPeriodHour;
	}
	public void setJobGroupPeriodHour(String jobGroupPeriodHour) {
		this.jobGroupPeriodHour = jobGroupPeriodHour;
	}
	public String getJobGroupPeriodMinute() {
		return jobGroupPeriodMinute;
	}
	public void setJobGroupPeriodMinute(String jobGroupPeriodMinute) {
		this.jobGroupPeriodMinute = jobGroupPeriodMinute;
	}
	public String getJobGroupPeriodSecond() {
		return jobGroupPeriodSecond;
	}
	public void setJobGroupPeriodSecond(String jobGroupPeriodSecond) {
		this.jobGroupPeriodSecond = jobGroupPeriodSecond;
	}
	public String getJobGroupDescription() {
		return jobGroupDescription;
	}
	public void setJobGroupDescription(String jobGroupDescription) {
		this.jobGroupDescription = jobGroupDescription;
	}
	public String getJobGroupStatus() {
		return jobGroupStatus;
	}
	public void setJobGroupStatus(String jobGroupStatus) {
		this.jobGroupStatus = jobGroupStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((jobGroupDescription == null) ? 0 : jobGroupDescription
						.hashCode());
		result = prime * result
				+ ((jobGroupName == null) ? 0 : jobGroupName.hashCode());
		result = prime * result
				+ ((jobGroupNumber == null) ? 0 : jobGroupNumber.hashCode());
		result = prime
				* result
				+ ((jobGroupPeriodDay == null) ? 0 : jobGroupPeriodDay
						.hashCode());
		result = prime
				* result
				+ ((jobGroupPeriodHour == null) ? 0 : jobGroupPeriodHour
						.hashCode());
		result = prime
				* result
				+ ((jobGroupPeriodMinute == null) ? 0 : jobGroupPeriodMinute
						.hashCode());
		result = prime
				* result
				+ ((jobGroupPeriodMonth == null) ? 0 : jobGroupPeriodMonth
						.hashCode());
		result = prime
				* result
				+ ((jobGroupPeriodSecond == null) ? 0 : jobGroupPeriodSecond
						.hashCode());
		result = prime
				* result
				+ ((jobGroupPeriodWeek == null) ? 0 : jobGroupPeriodWeek
						.hashCode());
		result = prime
				* result
				+ ((jobGroupPeriodYear == null) ? 0 : jobGroupPeriodYear
						.hashCode());
		result = prime * result
				+ ((jobGroupStatus == null) ? 0 : jobGroupStatus.hashCode());
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
		SysBatchTaskControl other = (SysBatchTaskControl) obj;
		if (jobGroupDescription == null) {
			if (other.jobGroupDescription != null)
				return false;
		} else if (!jobGroupDescription.equals(other.jobGroupDescription))
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
		if (jobGroupPeriodDay == null) {
			if (other.jobGroupPeriodDay != null)
				return false;
		} else if (!jobGroupPeriodDay.equals(other.jobGroupPeriodDay))
			return false;
		if (jobGroupPeriodHour == null) {
			if (other.jobGroupPeriodHour != null)
				return false;
		} else if (!jobGroupPeriodHour.equals(other.jobGroupPeriodHour))
			return false;
		if (jobGroupPeriodMinute == null) {
			if (other.jobGroupPeriodMinute != null)
				return false;
		} else if (!jobGroupPeriodMinute.equals(other.jobGroupPeriodMinute))
			return false;
		if (jobGroupPeriodMonth == null) {
			if (other.jobGroupPeriodMonth != null)
				return false;
		} else if (!jobGroupPeriodMonth.equals(other.jobGroupPeriodMonth))
			return false;
		if (jobGroupPeriodSecond == null) {
			if (other.jobGroupPeriodSecond != null)
				return false;
		} else if (!jobGroupPeriodSecond.equals(other.jobGroupPeriodSecond))
			return false;
		if (jobGroupPeriodWeek == null) {
			if (other.jobGroupPeriodWeek != null)
				return false;
		} else if (!jobGroupPeriodWeek.equals(other.jobGroupPeriodWeek))
			return false;
		if (jobGroupPeriodYear == null) {
			if (other.jobGroupPeriodYear != null)
				return false;
		} else if (!jobGroupPeriodYear.equals(other.jobGroupPeriodYear))
			return false;
		if (jobGroupStatus == null) {
			if (other.jobGroupStatus != null)
				return false;
		} else if (!jobGroupStatus.equals(other.jobGroupStatus))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SysBatchTaskControl [jobGroupNumber=" + jobGroupNumber
				+ ", jobGroupName=" + jobGroupName + ", jobGroupPeriodYear="
				+ jobGroupPeriodYear + ", jobGroupPeriodWeek="
				+ jobGroupPeriodWeek + ", jobGroupPeriodMonth="
				+ jobGroupPeriodMonth + ", jobGroupPeriodDay="
				+ jobGroupPeriodDay + ", jobGroupPeriodHour="
				+ jobGroupPeriodHour + ", jobGroupPeriodMinute="
				+ jobGroupPeriodMinute + ", jobGroupPeriodSecond="
				+ jobGroupPeriodSecond + ", jobGroupDescription="
				+ jobGroupDescription + ", jobGroupStatus=" + jobGroupStatus
				+ "]";
	}
	
}
