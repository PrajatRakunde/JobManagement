package com.taomish.JobManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taomish.JobManagement.Dto.JobDto;
import com.taomish.JobManagement.model.JobEntity;
import com.taomish.JobManagement.service.JobService;

@RestController
public class JobController {

	@Autowired
	JobService jobService;
	
	@PostMapping("/job")
	public JobEntity addJob(@RequestBody JobDto jobDto) {
		
		return jobService.addJob(jobDto);
		
	}
	
	@GetMapping("/job/{id}")
	public JobEntity getJob(@PathVariable("id") int id) {
		
		return jobService.getJob(id);
		
	}
	
}
