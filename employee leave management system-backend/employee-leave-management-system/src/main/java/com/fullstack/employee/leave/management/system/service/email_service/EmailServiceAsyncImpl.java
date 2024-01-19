package com.fullstack.employee.leave.management.system.service.email_service;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceAsyncImpl implements EmailServiceAsync{
    @Autowired
    private JavaMailSender emailSender;

    @Override
    @Async
    public void sendLeaveApplicationEmailAsync(LeavePlan leavePlan) {
        // Similar to the synchronous version, but marked with @Async
        // Adjust as needed
        String employeeEmail = leavePlan.getEmployee().getEmail();
        String managerEmail = "leavedemoemployee@gmail.com"; // Change to your manager's email

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(employeeEmail, managerEmail);
        message.setSubject("Leave Application");
        message.setText(
                "Leave Application Details:\n\n" +
                        "Employee Name: " + leavePlan.getEmployee().getName() + "\n" +
                        "From Date: " + leavePlan.getFromDate() + "\n" +
                        "To Date: " + leavePlan.getToDate() + "\n" +
                        "Leave Type: " + leavePlan.getType() + "\n" +
                        "Day Count: " + leavePlan.getDayCount()
        );

        emailSender.send(message);
    }

}
