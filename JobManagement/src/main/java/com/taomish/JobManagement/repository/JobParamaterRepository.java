package com.taomish.JobManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taomish.JobManagement.model.JobParametersEntity;

public interface JobParamaterRepository extends JpaRepository<JobParametersEntity, Integer>{

}
