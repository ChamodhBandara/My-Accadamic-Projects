package com.fullstack.employee.leave.management.system.service;

public class LeavePlanNotFoundException extends RuntimeException {
    public LeavePlanNotFoundException(String message) {
        super(message);
    }
}