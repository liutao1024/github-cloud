package cn.spring.mvn.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author LiuTao @date 2018年11月2日 下午6:07:17
 * @ClassName: SystemBatchTimeDispathControl 
 * @Description: 任务定时器
 */
@Entity
@Table(name = "sys_batch_task_timer")
public class SysBatchTaskTimer implements Serializable {
	/**@Fields serialVersionUID : TODO(Describe) 
	 */
	private static final long serialVersionUID = 7926125672640251235L;
	
	@Id
	@Column(name = "JOB_GROUP_NUMBER", nullable = false, length = 24)
	private String jobGroupNumber;//批量任务组批次号
	@Id
	@Column(name = "JOB_NUMBER", nullable = false, length = 24)
	private String jobNumber;//任务步骤号
	@Column(name = "JOB_NAME", nullable = false, length = 24)
	private String jobName;//任务名称
	@Column(name = "JOB_GROUP_NAME", nullable = false, length = 24)
	private String jobGroupName;//批量任务组批次名称
	@Column(name = "JOB_PATH", nullable = false, length = 24)
	private String jobPath;//任务路径
	@Column(name = "JOB_MODULE", nullable = false, length = 24)
	private String jobModule;//任务模块
	@Column(name = "JOB_CLASS", nullable = false, length = 24)
	private String jobClass;//任务类
	@Column(name = "JOB_METHOD", nullable = false, length = 24)
	private String jobMethod;//任务方法
	@Column(name = "JOB_PERIOD_YEAR", nullable = false, length = 24)
	private String jobPeriodYear;//调度周期--年份
	@Column(name = "JOB_PERIOD_WEEK", nullable = false, length = 24)
	private String jobPeriodWeek;//调度周期--周
	@Column(name = "JOB_PERIOD_MONTH", nullable = false, length = 24)
	private String jobPeriodMonth;//调度周期--月份
	@Column(name = "JOB_PERIOD_DAY", nullable = false, length = 24)
	private String jobPeriodDay;//调度周期--日
	@Column(name = "JOB_PERIOD_HOUR", nullable = false, length = 24)
	private String jobPeriodHour;//调度周期--小时
	@Column(name = "JOB_PERIOD_MINUTE", nullable = false, length = 24)
	private String jobPeriodMinute;//调度周期--分钟
	@Column(name = "JOB_PERIOD_SECOND", nullable = false, length = 24)
	private String jobPeriodSecond;//调度周期--秒钟
	@Column(name = "JOB_EXECUTE_TIME", nullable = false, length = 24)
	private Integer jobExecuteTime;//任务执行次数
	@Column(name = "JOB_DESCRIPTION", nullable = false, length = 24)
	private String jobDescription;//任务描述
	@Column(name = "JOB_EXECUTE_FLAG", nullable = false, length = 24)
	private String jobExecuteFlag;//任务执行标志(Y/N)
	//
	public String getJobGroupNumber() {
		return jobGroupNumber;
	}
	public void setJobGroupNumber(String jobGroupNumber) {
		this.jobGroupNumber = jobGroupNumber;
	}
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
	public String getJobGroupName() {
		return jobGroupName;
	}
	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}
	public String getJobPath() {
		return jobPath;
	}
	public void setJobPath(String jobPath) {
		this.jobPath = jobPath;
	}
	public String getJobModule() {
		return jobModule;
	}
	public void setJobModule(String jobModule) {
		this.jobModule = jobModule;
	}
	public String getJobClass() {
		return jobClass;
	}
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}
	public String getJobMethod() {
		return jobMethod;
	}
	public void setJobMethod(String jobMethod) {
		this.jobMethod = jobMethod;
	}
	public String getJobPeriodYear() {
		return jobPeriodYear;
	}
	public void setJobPeriodYear(String jobPeriodYear) {
		this.jobPeriodYear = jobPeriodYear;
	}
	public String getJobPeriodWeek() {
		return jobPeriodWeek;
	}
	public void setJobPeriodWeek(String jobPeriodWeek) {
		this.jobPeriodWeek = jobPeriodWeek;
	}
	public String getJobPeriodMonth() {
		return jobPeriodMonth;
	}
	public void setJobPeriodMonth(String jobPeriodMonth) {
		this.jobPeriodMonth = jobPeriodMonth;
	}
	public String getJobPeriodDay() {
		return jobPeriodDay;
	}
	public void setJobPeriodDay(String jobPeriodDay) {
		this.jobPeriodDay = jobPeriodDay;
	}
	public String getJobPeriodHour() {
		return jobPeriodHour;
	}
	public void setJobPeriodHour(String jobPeriodHour) {
		this.jobPeriodHour = jobPeriodHour;
	}
	public String getJobPeriodMinute() {
		return jobPeriodMinute;
	}
	public void setJobPeriodMinute(String jobPeriodMinute) {
		this.jobPeriodMinute = jobPeriodMinute;
	}
	public String getJobPeriodSecond() {
		return jobPeriodSecond;
	}
	public void setJobPeriodSecond(String jobPeriodSecond) {
		this.jobPeriodSecond = jobPeriodSecond;
	}
	public Integer getJobExecuteTime() {
		return jobExecuteTime;
	}
	public void setJobExecuteTime(Integer jobExecuteTime) {
		this.jobExecuteTime = jobExecuteTime;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobExecuteFlag() {
		return jobExecuteFlag;
	}
	public void setJobExecuteFlag(String jobExecuteFlag) {
		this.jobExecuteFlag = jobExecuteFlag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jobClass == null) ? 0 : jobClass.hashCode());
		result = prime * result
				+ ((jobDescription == null) ? 0 : jobDescription.hashCode());
		result = prime * result
				+ ((jobExecuteFlag == null) ? 0 : jobExecuteFlag.hashCode());
		result = prime * result
				+ ((jobExecuteTime == null) ? 0 : jobExecuteTime.hashCode());
		result = prime * result
				+ ((jobGroupName == null) ? 0 : jobGroupName.hashCode());
		result = prime * result
				+ ((jobGroupNumber == null) ? 0 : jobGroupNumber.hashCode());
		result = prime * result
				+ ((jobMethod == null) ? 0 : jobMethod.hashCode());
		result = prime * result
				+ ((jobModule == null) ? 0 : jobModule.hashCode());
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result
				+ ((jobNumber == null) ? 0 : jobNumber.hashCode());
		result = prime * result + ((jobPath == null) ? 0 : jobPath.hashCode());
		result = prime * result
				+ ((jobPeriodDay == null) ? 0 : jobPeriodDay.hashCode());
		result = prime * result
				+ ((jobPeriodHour == null) ? 0 : jobPeriodHour.hashCode());
		result = prime * result
				+ ((jobPeriodMinute == null) ? 0 : jobPeriodMinute.hashCode());
		result = prime * result
				+ ((jobPeriodMonth == null) ? 0 : jobPeriodMonth.hashCode());
		result = prime * result
				+ ((jobPeriodSecond == null) ? 0 : jobPeriodSecond.hashCode());
		result = prime * result
				+ ((jobPeriodWeek == null) ? 0 : jobPeriodWeek.hashCode());
		result = prime * result
				+ ((jobPeriodYear == null) ? 0 : jobPeriodYear.hashCode());
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
		SysBatchTaskTimer other = (SysBatchTaskTimer) obj;
		if (jobClass == null) {
			if (other.jobClass != null)
				return false;
		} else if (!jobClass.equals(other.jobClass))
			return false;
		if (jobDescription == null) {
			if (other.jobDescription != null)
				return false;
		} else if (!jobDescription.equals(other.jobDescription))
			return false;
		if (jobExecuteFlag == null) {
			if (other.jobExecuteFlag != null)
				return false;
		} else if (!jobExecuteFlag.equals(other.jobExecuteFlag))
			return false;
		if (jobExecuteTime == null) {
			if (other.jobExecuteTime != null)
				return false;
		} else if (!jobExecuteTime.equals(other.jobExecuteTime))
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
		if (jobMethod == null) {
			if (other.jobMethod != null)
				return false;
		} else if (!jobMethod.equals(other.jobMethod))
			return false;
		if (jobModule == null) {
			if (other.jobModule != null)
				return false;
		} else if (!jobModule.equals(other.jobModule))
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
		if (jobPath == null) {
			if (other.jobPath != null)
				return false;
		} else if (!jobPath.equals(other.jobPath))
			return false;
		if (jobPeriodDay == null) {
			if (other.jobPeriodDay != null)
				return false;
		} else if (!jobPeriodDay.equals(other.jobPeriodDay))
			return false;
		if (jobPeriodHour == null) {
			if (other.jobPeriodHour != null)
				return false;
		} else if (!jobPeriodHour.equals(other.jobPeriodHour))
			return false;
		if (jobPeriodMinute == null) {
			if (other.jobPeriodMinute != null)
				return false;
		} else if (!jobPeriodMinute.equals(other.jobPeriodMinute))
			return false;
		if (jobPeriodMonth == null) {
			if (other.jobPeriodMonth != null)
				return false;
		} else if (!jobPeriodMonth.equals(other.jobPeriodMonth))
			return false;
		if (jobPeriodSecond == null) {
			if (other.jobPeriodSecond != null)
				return false;
		} else if (!jobPeriodSecond.equals(other.jobPeriodSecond))
			return false;
		if (jobPeriodWeek == null) {
			if (other.jobPeriodWeek != null)
				return false;
		} else if (!jobPeriodWeek.equals(other.jobPeriodWeek))
			return false;
		if (jobPeriodYear == null) {
			if (other.jobPeriodYear != null)
				return false;
		} else if (!jobPeriodYear.equals(other.jobPeriodYear))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SysBatchTaskTimer [jobGroupNumber=" + jobGroupNumber
				+ ", jobNumber=" + jobNumber + ", jobName=" + jobName
				+ ", jobGroupName=" + jobGroupName + ", jobPath=" + jobPath
				+ ", jobModule=" + jobModule + ", jobClass=" + jobClass
				+ ", jobMethod=" + jobMethod + ", jobPeriodYear="
				+ jobPeriodYear + ", jobPeriodWeek=" + jobPeriodWeek
				+ ", jobPeriodMonth=" + jobPeriodMonth + ", jobPeriodDay="
				+ jobPeriodDay + ", jobPeriodHour=" + jobPeriodHour
				+ ", jobPeriodMinute=" + jobPeriodMinute + ", jobPeriodSecond="
				+ jobPeriodSecond + ", jobExecuteTime=" + jobExecuteTime
				+ ", jobDescription=" + jobDescription + ", jobExecuteFlag="
				+ jobExecuteFlag + "]";
	}
	
}
