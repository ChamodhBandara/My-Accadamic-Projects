package com.fullstack.employee.leave.management.system.service.email_service;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import org.springframework.scheduling.annotation.Async;

public interface EmailServiceAsync {

    void sendLeaveApplicationEmailAsync(String toEmail, String subject, String text);
}