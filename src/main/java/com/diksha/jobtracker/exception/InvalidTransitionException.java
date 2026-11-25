package com.diksha.jobtracker.exception;

import com.diksha.jobtracker.entity.ApplicationStatus;

public class InvalidStatusTransitionException extends RuntimeException {

    public InvalidStatusTransitionException(ApplicationStatus from, ApplicationStatus to) {
        super("Cannot move from " + from + " to " + to);
    }
}
