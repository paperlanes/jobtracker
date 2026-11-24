package com.diksha.jobtracker.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateApplicationRequest(@NotBlank String company,
                                       @NotBlank String role,
                                       LocalDate appliedDate,
                                       String jobDescription) {

}
