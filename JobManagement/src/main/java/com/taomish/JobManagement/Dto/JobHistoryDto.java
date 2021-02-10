package com.taomish.JobManagement.Dto;

import java.util.Date;
import java.util.Map;

import com.taomish.JobManagement.model.JobParametersEntity;

public class JobHistoryDto {

	private int id;

	private Date startTime;

	private Date endTime;

	private Map<String, String> status;

	private boolean published;

	private String errorDetail;

	private String loggedBy;

	private JobParametersEntity jobParams;

	public JobHistoryDto() {
	}

	public JobHistoryDto(int id, Date startTime, Date endTime, Map<String, String> status, boolean published,
			String errorDetail, String loggedBy, JobParametersEntity jobParams) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.published = published;
		this.errorDetail = errorDetail;
		this.loggedBy = loggedBy;
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

	public Map<String, String> getStatus() {
		return status;
	}

	public void setStatus(Map<String, String> status) {
		this.status = status;
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

	public JobParametersEntity getJobParams() {
		return jobParams;
	}

	public void setJobParams(JobParametersEntity jobParams) {
		this.jobParams = jobParams;
	}
	
	

}
