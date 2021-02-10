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
import com.taomish.JobManagement.model.JobEntity;
import com.taomish.JobManagement.repository.JobRepository;

@ExtendWith(MockitoExtension.class)
class JobServiceImplTest {

	@InjectMocks
	private JobServiceImpl jobService;
	
	@Mock
	private JobRepository jobRepository;
	
	private JobDto jobDto;
	
	private JobEntity job;
	
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
		
	}
	
	@Test
	public void testAddJob() {
		jobRepository.save(job);
		JobEntity newJob = jobService.addJob(jobDto);
		
		assertEquals(job.getId(), newJob.getId());
		
	}
	
	@Test
	public void testGetJob() {
		when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));
		JobEntity newJob = jobService.getJob(job.getId());
		assertEquals(job, newJob);
	}

}
