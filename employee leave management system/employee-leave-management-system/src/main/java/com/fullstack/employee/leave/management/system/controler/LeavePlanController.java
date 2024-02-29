package com.fullstack.employee.leave.management.system.controler;
import com.fullstack.employee.leave.management.system.model.LeavePlan;
import com.fullstack.employee.leave.management.system.service.LeavePlanNotFoundException;
import com.fullstack.employee.leave.management.system.service.LeavePlanService;
import com.fullstack.employee.leave.management.system.service.email_service.EmailServiceAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/leaveplan")
public class LeavePlanController {

    @Autowired
    private LeavePlanService leavePlanService;

    @Autowired
    private EmailServiceAsync emailServiceAsync;


    @Value("${leave.application.email.to}")
    private String leaveApplicationEmailTo;


    @GetMapping
    public ResponseEntity<List<LeavePlan>> getAllLeavePlans() {
        List<LeavePlan> leavePlans = leavePlanService.getAllLeavePlans();
        return ResponseEntity.ok(leavePlans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeavePlan> getLeavePlanById(@PathVariable int id) {
        try {
            LeavePlan leavePlan = leavePlanService.getLeavePlanById(id);
            return ResponseEntity.ok(leavePlan);
        } catch (LeavePlanNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping
//    public ResponseEntity<LeavePlan> addLeavePlan(@RequestBody LeavePlan leavePlan) {
//        LeavePlan savedLeavePlan = leavePlanService.addLeavePlan(leavePlan);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedLeavePlan);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<LeavePlan> updateLeavePlan(@PathVariable int id, @RequestBody LeavePlan leavePlan) {
        try {
            LeavePlan updatedLeavePlan = leavePlanService.updateLeavePlan(id, leavePlan);
            return ResponseEntity.ok(updatedLeavePlan);
        } catch (LeavePlanNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeavePlan(@PathVariable int id) {
        try {
            leavePlanService.deleteLeavePlan(id);
            return ResponseEntity.noContent().build();
        } catch (LeavePlanNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{employeeId}")
    public ResponseEntity<LeavePlan> addLeavePlanAndSendEmail(
            @PathVariable int employeeId,
            @RequestBody LeavePlan leavePlan) {
        LeavePlan savedLeavePlan = leavePlanService.addLeavePlan(leavePlan);

        // Send email asynchronously
        sendLeaveApplicationEmailAsync(savedLeavePlan);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedLeavePlan);
    }

    private void sendLeaveApplicationEmailAsync(LeavePlan leavePlan) {
        String subject = "Leave Application Submitted";
        String text = String.format(
                "Leave Application Details:\n\nFrom Date: %s\nTo Date: %s\nLeave Type: %s\nDays of Count: %d",
                leavePlan.getFromDate(), leavePlan.getToDate(), leavePlan.getLeaveType(), leavePlan.getDayCount());

        emailServiceAsync.sendLeaveApplicationEmailAsync(leaveApplicationEmailTo, subject, text);
    }

    @PostMapping("/send-email/{employeeId}")
    public ResponseEntity<Void> sendLeaveApplicationEmail(@PathVariable int employeeId) {
        try {
            // Retrieve leave details from the database based on employeeId
            List<LeavePlan> leavePlans = leavePlanService.getLeavePlansByEmployeeId(employeeId);

            // Check if the list is not empty
            if (!leavePlans.isEmpty()) {
                LeavePlan leavePlan = leavePlans.get(0);

                // Send email synchronously (you can choose to make it asynchronous if needed)
                sendLeaveApplicationEmailSync(leavePlan);

                return ResponseEntity.ok().build();
            } else {
                // Handle the case where no leave plans are found for the given employeeId
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception for backend debugging
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private void sendLeaveApplicationEmailSync(LeavePlan leavePlan) {
        String subject = "Leave Application Submitted";
        String text = String.format(
                "Leave Application Details:\n\nFrom Date: %s\nTo Date: %s\nLeave Type: %s\nDays of Count: %d",
                leavePlan.getFromDate(), leavePlan.getToDate(), leavePlan.getLeaveType(), leavePlan.getDayCount());

        emailServiceAsync.sendLeaveApplicationEmailAsync(leaveApplicationEmailTo, subject, text);
    }
}