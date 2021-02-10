package com.taomish.JobManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taomish.JobManagement.Dto.JobDto;
import com.taomish.JobManagement.Exception.BadRequestException;
import com.taomish.JobManagement.Exception.JobNotFoundException;
import com.taomish.JobManagement.model.JobEntity;
import com.taomish.JobManagement.repository.JobHistoryRepository;
import com.taomish.JobManagement.repository.JobParamaterRepository;
import com.taomish.JobManagement.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	JobHistoryRepository jobHistoryRepository;
	
	@Autowired
	JobParamaterRepository jobParamRepository;

	@Override
	public JobEntity addJob(JobDto jobDto) {
		
		JobEntity job = new JobEntity();

		job.setLastRunDate(jobDto.getLastRunDate()); 
		job.setSchedule(jobDto.getSchedule()); 
		job.setWeekdays(jobDto.getWeekdays());
		job.setMonthlyDate(jobDto.getMonthlyDate());
		
		try {
			jobRepository.save(job);
		}
		catch(BadRequestException e) {}
		catch(Exception e) {}
		
		return job;
		
	}

	@Override
	public JobEntity getJob(int id) {
		
		Optional<JobEntity> job = jobRepository.findById(id);
		if(job.isEmpty()) {
			throw new JobNotFoundException("job not found");
		}

		return job.get();
	}	
	
}
