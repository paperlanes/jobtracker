package com.diksha.jobtracker.repository;

import com.diksha.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
}
