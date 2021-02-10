package com.taomish.JobManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taomish.JobManagement.Dto.JobHistoryDto;
import com.taomish.JobManagement.model.JobHistoryEntity;
import com.taomish.JobManagement.service.JobHistoryService;

@RestController
public class JobHistoryController {

	@Autowired
	JobHistoryService jhService;
	
	@PostMapping("/job-history")
	public JobHistoryEntity addJobHistory(@RequestBody JobHistoryDto jhDto) {
		
		return jhService.addJobHistory(jhDto);
		
	}
	
	@GetMapping("/job-history/{id}")
	public JobHistoryEntity getJobHistory(@PathVariable("id") int id) {
		
		return jhService.getJobHistory(id);
		
	}
	
}
