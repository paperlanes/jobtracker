package com.diksha.jobtracker.service;

import com.diksha.jobtracker.dto.ApplicationResponse;
import com.diksha.jobtracker.dto.CreateApplicationRequest;
import com.diksha.jobtracker.entity.ApplicationStatus;
import com.diksha.jobtracker.entity.JobApplication;
import com.diksha.jobtracker.exception.ApplicationNotFoundException;
import com.diksha.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobApplicationService {
    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;

    }

    public ApplicationResponse create(CreateApplicationRequest request) {
        JobApplication app = new JobApplication(request.company(), request.role());
        app.setJobDescription(request.jobDescription());
        app.setStatus(ApplicationStatus.APPLIED);

        if (request.appliedDate() != null) {
            app.setAppliedDate(request.appliedDate());
        } else {
            app.setAppliedDate(LocalDate.now());
        }

        JobApplication saved = repository.save(app);
        return ApplicationResponse.from(saved);
    }

    public ApplicationResponse getById(Long id) {
        JobApplication app = repository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException(id));
        return ApplicationResponse.from(app);
    }

    public List<ApplicationResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(ApplicationResponse::from)
                .toList();
    }

}
