package com.fullstack.employee.leave.management.system.service;

public class EmployeeIdNotUniqueException extends RuntimeException {
    public EmployeeIdNotUniqueException(String message) {
        super(message);
    }
}
