package com.diksha.jobtracker.entity;

public enum ApplicationStatus {
    APPLIED, OA, INTERVIEW, OFFER, REJECTED;
    public boolean canMoveTo(ApplicationStatus next) {
        return switch (this) {
            case APPLIED -> next == OA || next == INTERVIEW || next == REJECTED;
            case OA -> next == INTERVIEW || next == REJECTED;
            case INTERVIEW -> next == OFFER || next == REJECTED;
            case OFFER, REJECTED -> false;
        };
    }
}
