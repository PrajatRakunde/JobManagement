package com.taomish.JobManagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taomish.JobManagement.Dto.JobDto;
import com.taomish.JobManagement.Dto.JobHistoryDto;
import com.taomish.JobManagement.model.JobEntity;
import com.taomish.JobManagement.model.JobHistoryEntity;
import com.taomish.JobManagement.model.JobParametersEntity;
import com.taomish.JobManagement.repository.JobHistoryRepository;
import com.taomish.JobManagement.repository.JobParamaterRepository;
import com.taomish.JobManagement.repository.JobRepository;

@ExtendWith(MockitoExtension.class)
class JobHistoryServiceImplTest {

	@InjectMocks
	private JobHistoryServiceImpl jhService;
	
	@Mock
	private JobHistoryRepository jhRepository;
	
	@Mock
	private JobRepository jobRepository;
	
	@Mock
	private JobParamaterRepository jpRepository;
	
	private JobHistoryDto jhDto;
	
	private JobDto jobDto;
	
	private JobEntity job;
	
	private JobHistoryEntity jh;
	
	private Map<String, String> status;
	
	private JobParametersEntity jobParams;
	
	@BeforeEach
	public void init() {
		
		Map<String, Boolean> weekdays = new HashMap<>();
		weekdays.put("monday", true);
		jobDto = new JobDto(new Date(), "weekends", weekdays, 15);
		job = new JobEntity();
		job.setLastRunDate(jobDto.getLastRunDate());
		job.setMonthlyDate(jobDto.getMonthlyDate());
		job.setSchedule(jobDto.getSchedule());
		job.setWeekdays(weekdays);
		status = new HashMap<>();
		status.put("technical round", "passed");
		status.put("assignment", "in-progress");
		jobParams = new JobParametersEntity(job.getId(), "xyz", "BLR", "IND");
		jhDto = new JobHistoryDto(job.getId(), new Date(), new Date(), status, true, "no errors", "xyz", jobParams);
		jh = new JobHistoryEntity();
		jh.setId(job.getId());
		jh.setEndTime(jhDto.getEndTime());
		jh.setErrorDetail(jhDto.getErrorDetail());
		jh.setJob(job);
		jh.setJobParams(jobParams);
		jh.setLoggedBy(jhDto.getLoggedBy());
		jh.setPublished(jhDto.isPublished());
		jh.setStartTime(jhDto.getStartTime());
		jh.setStatus(jhDto.getStatus());
		
	}
	
	@Test
	public void addJobHistoryTest() {
		
		jobRepository.save(job);
		jpRepository.save(jobParams);
		jhRepository.save(jh);
		when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));
		
		JobHistoryEntity newJh = jhService.addJobHistory(jhDto);
		assertEquals(jh.getId(), newJh.getId());
		
	}
	
	@Test
	public void getJobHistoryTest() {
		
		when(jhRepository.findById(job.getId())).thenReturn(Optional.of(jh));
		JobHistoryEntity newJh = jhService.getJobHistory(job.getId());
		
		assertEquals(jh.getId(), newJh.getId());
		
	}

}
