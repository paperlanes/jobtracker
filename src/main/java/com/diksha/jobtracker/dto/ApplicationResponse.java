package com.diksha.jobtracker.dto;

import com.diksha.jobtracker.entity.ApplicationStatus;
import com.diksha.jobtracker.entity.JobApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ApplicationResponse(
        Long id,
        String company,
        String role,
        ApplicationStatus status,
        LocalDate appliedDate,
        LocalDateTime createdAt
) {
    public static ApplicationResponse from(JobApplication app) {
        return new ApplicationResponse(
                app.getId(), app.getCompany(), app.getRole(), app.getStatus(), app.getAppliedDate(), app.getCreatedAt()
        );
    }
}
