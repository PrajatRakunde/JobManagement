package com.taomish.JobManagement.service;

import com.taomish.JobManagement.Dto.JobHistoryDto;
import com.taomish.JobManagement.model.JobHistoryEntity;

public interface JobHistoryService {

	public JobHistoryEntity addJobHistory(JobHistoryDto jobHistoryDto);
	
	public JobHistoryEntity getJobHistory(int id);
	
}
