package com.fullstack.employee.leave.management.system.service;

import com.fullstack.employee.leave.management.system.model.Employee;
import com.fullstack.employee.leave.management.system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private LeavePlanService leavePlanService;

    @Value("${spring.mail.username}")
    private String senderEmail;

    // Get employees with pagination
    public Page<Employee> getEmployeesPaged(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        // Save the employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Send email notification
        sendEmailNotification(savedEmployee);

        // Return the saved employee
        return savedEmployee;
    }

    // Make the method public
    public void sendEmailNotification(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("chamodh07abeykoon@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        try {
            javaMailSender.send(message);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Mail send successfully....");
    }

    public void sendEmailNotification(Employee employee) {
        // Customize the email subject and body as needed
        String subject = "Employee Notification";
        String body = "Dear " + employee.getName() + ",\n\nYour record has been created.";

        sendEmailNotification(employee.getEmail(), subject, body);
    }
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        // Update the existing employee with new data
        existingEmployee.setEmpNo(updatedEmployee.getEmpNo());
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setDob(updatedEmployee.getDob());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        // Save and return the updated employee
        Employee savedEmployee = employeeRepository.save(existingEmployee);
        // Send email notification
        sendEmailNotification(savedEmployee);
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(int id) {
        Employee existingEmployee = getEmployeeById(id);
        // Delete the employee
        employeeRepository.delete(existingEmployee);
    }

    public boolean employeeExists(int id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        return existingEmployee.isPresent();
    }

    public boolean employeeExistsById(int id) {
        return employeeRepository.existsById(id);
    }


}
