package com.taomish.JobManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taomish.JobManagement.Dto.JobHistoryDto;
import com.taomish.JobManagement.Exception.BadRequestException;
import com.taomish.JobManagement.Exception.JobHistoryNotFoundException;
import com.taomish.JobManagement.Exception.JobNotFoundException;
import com.taomish.JobManagement.model.JobEntity;
import com.taomish.JobManagement.model.JobHistoryEntity;
import com.taomish.JobManagement.repository.JobHistoryRepository;
import com.taomish.JobManagement.repository.JobParamaterRepository;
import com.taomish.JobManagement.repository.JobRepository;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {
	
	@Autowired
	JobHistoryRepository jhRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	JobParamaterRepository jpRepository;

	@Override
	public JobHistoryEntity addJobHistory(JobHistoryDto jhDto) {
		
		Optional<JobEntity> job = jobRepository.findById(jhDto.getId());
		
		if(job.isEmpty()) {
			throw new JobNotFoundException("job not found");
		}
		
		JobHistoryEntity jh = new JobHistoryEntity();
		jh.setId(jhDto.getId());
		jh.setEndTime(jhDto.getEndTime());
		jh.setErrorDetail(jhDto.getErrorDetail());
		jh.setLoggedBy(jhDto.getLoggedBy());
		jh.setPublished(jhDto.isPublished());
		jh.setStartTime(jhDto.getStartTime());
		jh.setStatus(jhDto.getStatus());
		jh.setJob(job.get());
		jh.setJobParams(jhDto.getJobParams());
		
		try {
			jpRepository.save(jhDto.getJobParams());
			jhRepository.save(jh);
		}
		catch(BadRequestException e) {}
		catch(Exception e) {}
		
		return jh;
		
	}

	@Override
	public JobHistoryEntity getJobHistory(int id) {
		
		Optional<JobHistoryEntity> jh = jhRepository.findById(id);
		
		if(jh.isEmpty()) {
			throw new JobHistoryNotFoundException("Job history not found");
		}
		
		return jh.get();
		
	}

}
