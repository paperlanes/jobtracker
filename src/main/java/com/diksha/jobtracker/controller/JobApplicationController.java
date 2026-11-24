package com.diksha.jobtracker.controller;

import com.diksha.jobtracker.dto.ApplicationResponse;
import com.diksha.jobtracker.dto.CreateApplicationRequest;
import com.diksha.jobtracker.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")

public class JobApplicationController {
    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationResponse create(@Valid @RequestBody CreateApplicationRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ApplicationResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ApplicationResponse> getAll() {
        return service.getAll();
    }
}
