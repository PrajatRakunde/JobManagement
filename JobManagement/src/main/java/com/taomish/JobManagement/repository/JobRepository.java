package com.taomish.JobManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taomish.JobManagement.model.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Integer>{

}
