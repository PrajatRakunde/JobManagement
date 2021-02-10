package com.taomish.JobManagement.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="job_history_table")
public class JobHistoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id")
	private int id;
	
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	private Date endTime;
	
	@ElementCollection
    @MapKeyColumn(name="step")
    @Column(name="status")
    @CollectionTable(name="status", joinColumns=@JoinColumn(name="status_id"))
	private Map<String, String> status;
	
	private boolean published;
	
	@Column(name="error_detail")
	private String errorDetail;
	
	@Column(name="logged_by")
	private String loggedBy;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "job_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private JobEntity job;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "job_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private JobParametersEntity jobParams;

	public JobHistoryEntity() {
		
	}

	public JobHistoryEntity(int id, Date startTime, Date endTime,
			Map<String, String> status, boolean published, String errorDetail, String loggedBy, JobEntity job,
			JobParametersEntity jobParams) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.published = published;
		this.errorDetail = errorDetail;
		this.loggedBy = loggedBy;
		this.job = job;
		this.jobParams = jobParams;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public String getLoggedBy() {
		return loggedBy;
	}

	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
	}

	public JobEntity getJob() {
		return job;
	}

	public void setJob(JobEntity job) {
		this.job = job;
	}

	public Map<String, String> getStatus() {
		return status;
	}

	public void setStatus(Map<String, String> status) {
		this.status = status;
	}

	public JobParametersEntity getJobParams() {
		return jobParams;
	}

	public void setJobParams(JobParametersEntity jobParams) {
		this.jobParams = jobParams;
	}
	
	
	
}
