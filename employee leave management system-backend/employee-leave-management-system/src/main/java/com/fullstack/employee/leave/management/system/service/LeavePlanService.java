package com.fullstack.employee.leave.management.system.service;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import com.fullstack.employee.leave.management.system.repository.LeavePlanRepository;
import com.fullstack.employee.leave.management.system.service.email_service.EmailServiceAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavePlanService {
    @Autowired
    private LeavePlanRepository leavePlanRepository;

    @Autowired
    private EmailServiceAsync emailServiceAsync;

    public List<LeavePlan> getAllLeavePlans() {
        return leavePlanRepository.findAll();
    }

    public LeavePlan addLeavePlan(LeavePlan leavePlan) {

        LeavePlan savedLeavePlan = leavePlanRepository.save(leavePlan);

        // Send email to the employee and manager
        emailServiceAsync.sendLeaveApplicationEmailAsync(savedLeavePlan);

        return savedLeavePlan;
    }

//    private void sendLeaveApplicationEmail(LeavePlan leavePlan) {
//        String employeeEmail = leavePlan.getEmployee().getEmail();
//        String managerEmail = "leavedemoemployee@gmail.com";
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(employeeEmail, managerEmail);
//        message.setSubject("Leave Application");
//        message.setText(
//                "Leave Application Details:\n\n" +
//                        "Employee Name: " + leavePlan.getEmployee().getName() + "\n" +
//                        "From Date: " + leavePlan.getFromDate() + "\n" +
//                        "To Date: " + leavePlan.getToDate() + "\n" +
//                        "Leave Type: " + leavePlan.getType() + "\n" +
//                        "Day Count: " + leavePlan.getDayCount()
//        );
//
//        emailSender.send(message);
//    }

    public LeavePlan updateLeavePlan(int id, LeavePlan updatedLeavePlan) {
        LeavePlan existingLeavePlan = getLeavePlanById(id);
        // Update the existing leave plan with new data
        existingLeavePlan.setEmployee(updatedLeavePlan.getEmployee());
        existingLeavePlan.setFromDate(updatedLeavePlan.getFromDate());
        existingLeavePlan.setToDate(updatedLeavePlan.getToDate());
        existingLeavePlan.setType(updatedLeavePlan.getType());
        existingLeavePlan.setDayCount(updatedLeavePlan.getDayCount());
        // Save and return the updated leave plan
        return leavePlanRepository.save(existingLeavePlan);
    }

    public void deleteLeavePlan(int id) {
        LeavePlan existingLeavePlan = getLeavePlanById(id);
        // Delete the leave plan
        leavePlanRepository.delete(existingLeavePlan);
    }

    public LeavePlan getLeavePlanById(int id) {
        return leavePlanRepository.findById(id)
                .orElseThrow(() -> new LeavePlanNotFoundException("Leave plan not found with id: " + id));
    }
    public List<LeavePlan> getLeavePlansByEmployeeId(int employeeId) {
        return leavePlanRepository.findByEmployeeId(employeeId);
    }
}
