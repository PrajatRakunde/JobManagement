package com.taomish.JobManagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomish.JobManagement.Dto.JobDto;
import com.taomish.JobManagement.Dto.JobHistoryDto;
import com.taomish.JobManagement.model.JobEntity;
import com.taomish.JobManagement.model.JobHistoryEntity;
import com.taomish.JobManagement.model.JobParametersEntity;
import com.taomish.JobManagement.repository.JobHistoryRepository;
import com.taomish.JobManagement.repository.JobParamaterRepository;
import com.taomish.JobManagement.repository.JobRepository;
import com.taomish.JobManagement.service.JobHistoryServiceImpl;
import com.taomish.JobManagement.service.JobServiceImpl;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value= JobHistoryController.class)
class JobHistoryControllerTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private JobHistoryServiceImpl jhService;
	
	@MockBean
	private JobServiceImpl jobService;
		
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
	public void testAddJobHistoryTest() throws Exception {
		
		jobRepository.save(job);
		jpRepository.save(jobParams);
		jhRepository.save(jh);
		when(jhService.addJobHistory(jhDto)).thenReturn(jh);
		
		RequestBuilder request = MockMvcRequestBuilders.post("/job-history")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(jhDto));
		
		mockMvc.perform(request)
			.andExpect(status().is(200));
		
	}
	
	@Test
	public void testGetJobHistory() throws Exception {
		when(jhService.getJobHistory(job.getId())).thenReturn(jh);
		jobRepository.save(job);
		jpRepository.save(jobParams);
		jhRepository.save(jh);
		RequestBuilder request = MockMvcRequestBuilders.get("/job-history/" + job.getId());
		mockMvc.perform(request)
			.andExpect(status().is(200));
	}

}
