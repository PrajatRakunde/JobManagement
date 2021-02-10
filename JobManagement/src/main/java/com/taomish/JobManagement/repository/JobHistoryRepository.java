package com.taomish.JobManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taomish.JobManagement.model.JobHistoryEntity;

public interface JobHistoryRepository extends JpaRepository<JobHistoryEntity, Integer> {

}
