package com.fullstack.employee.leave.management.system.service.email_service;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceAsyncImpl implements EmailServiceAsync {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    @Override
    public void sendLeaveApplicationEmailAsync(String toEmail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}

