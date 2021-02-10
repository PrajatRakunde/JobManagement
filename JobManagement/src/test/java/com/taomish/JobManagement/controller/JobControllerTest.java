package com.taomish.JobManagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomish.JobManagement.Dto.JobDto;
import com.taomish.JobManagement.model.JobEntity;
import com.taomish.JobManagement.repository.JobRepository;
import com.taomish.JobManagement.service.JobServiceImpl;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value= JobController.class)
class JobControllerTest {

	@MockBean
	private JobServiceImpl jobService;
	
	@Mock
	private JobRepository jobRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mockMvc;
	
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
	public void testAddJob() throws Exception {
		
		when(jobService.addJob(jobDto)).thenReturn(job);
		jobRepository.save(job);
		RequestBuilder request = MockMvcRequestBuilders.post("/job")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(jobDto));
		
		mockMvc.perform(request)
			.andExpect(status().is(200));
		
	}
	
	@Test
	public void testGetJob() throws Exception {
		when(jobService.getJob(job.getId())).thenReturn(job);
		jobRepository.save(job);
		RequestBuilder request = MockMvcRequestBuilders.get("/job/" + job.getId());
		mockMvc.perform(request)
			.andExpect(status().is(200));
	}

}
