package com.fullstack.employee.leave.management.system;


import com.fullstack.employee.leave.management.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Scanner;


@EnableAsync
@SpringBootApplication
public class EmployeeLeaveManagementSystemApplication {
	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeLeaveManagementSystemApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		employeeService.sendEmailNotification("chamodh07abeykoon@gmail.com",
				"Employee Created",
				"You were successfully created...");


	}
}
