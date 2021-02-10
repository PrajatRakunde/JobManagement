package com.taomish.JobManagement.Dto;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JobDto {

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastRunDate;

	private String schedule;

	private Map<String, Boolean> weekdays;

	private int monthlyDate;

	public JobDto(Date lastRunDate, String schedule, Map<String, Boolean> weekdays, int monthlyDate) {
		this.lastRunDate = lastRunDate;
		this.schedule = schedule;
		this.weekdays = weekdays;
		this.monthlyDate = monthlyDate;
	}

	
	public JobDto() {
	}


	public Date getLastRunDate() {
		return lastRunDate;
	}

	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Map<String, Boolean> getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(Map<String, Boolean> weekdays) {
		this.weekdays = weekdays;
	}

	public int getMonthlyDate() {
		return monthlyDate;
	}

	public void setMonthlyDate(int monthlyDate) {
		this.monthlyDate = monthlyDate;
	}	
	
	

}
