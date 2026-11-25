package com.diksha.jobtracker.entity;

import com.diksha.jobtracker.exception.InvalidStatusTransitionException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status;

    private LocalDate appliedDate;

    @Column(columnDefinition = "TEXT")
    private String jobDescription;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    protected JobApplication() {

    }
    public JobApplication(String company, String role){
        this.company=company;
        this.role=role;
        this.status = ApplicationStatus.APPLIED;
    }


    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void moveTo(ApplicationStatus next) {
        if (!status.canMoveTo(next)) {
            throw new InvalidStatusTransitionException(status, next);
        }
        this.status = next;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


}
