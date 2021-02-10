package com.taomish.JobManagement.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "job_table")
public class JobEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "last_run_date")
	private Date lastRunDate;

	private String schedule;

	@ElementCollection
	@MapKeyColumn(name = "day")
	@Column(name = "interview")
	@CollectionTable(name = "weekdays", joinColumns = @JoinColumn(name = "weekdays_id"))
	private Map<String, Boolean> weekdays;

	@Column(name = "monthly_date")
	private int monthlyDate;

	public JobEntity() {

	}

	public JobEntity(int id, Date lastRunDate, String schedule, Map<String, Boolean> weekdays, int monthlyDate) {
		this.id = id;
		this.lastRunDate = lastRunDate;
		this.schedule = schedule;
		this.weekdays = weekdays;
		this.monthlyDate = monthlyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
