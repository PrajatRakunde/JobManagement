package com.taomish.JobManagement.service;

import com.taomish.JobManagement.Dto.JobDto;
import com.taomish.JobManagement.model.JobEntity;

public interface JobService {

	public JobEntity addJob(JobDto jobDto);
	
	public JobEntity getJob(int id);
	
}
