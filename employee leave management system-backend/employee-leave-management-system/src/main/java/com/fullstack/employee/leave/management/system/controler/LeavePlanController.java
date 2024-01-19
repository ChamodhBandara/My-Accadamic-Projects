package com.fullstack.employee.leave.management.system.controler;
import com.fullstack.employee.leave.management.system.model.LeavePlan;
import com.fullstack.employee.leave.management.system.service.LeavePlanNotFoundException;
import com.fullstack.employee.leave.management.system.service.LeavePlanService;
import com.fullstack.employee.leave.management.system.service.email_service.EmailService;
import com.fullstack.employee.leave.management.system.service.email_service.EmailServiceAsync;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Get all leave plans
    @GetMapping
    public ResponseEntity<List<LeavePlan>> getAllLeavePlans() {
        List<LeavePlan> leavePlans = leavePlanService.getAllLeavePlans();
        return ResponseEntity.ok(leavePlans);
    }

    // Get a specific leave plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<LeavePlan> getLeavePlanById(@PathVariable int id) {
        try {
            LeavePlan leavePlan = leavePlanService.getLeavePlanById(id);
            return ResponseEntity.ok(leavePlan);
        } catch (LeavePlanNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new leave plan
    @PostMapping
    public ResponseEntity<LeavePlan> addLeavePlan( @RequestBody LeavePlan leavePlan) {
        LeavePlan savedLeavePlan = leavePlanService.addLeavePlan(leavePlan);
        emailServiceAsync.sendLeaveApplicationEmailAsync(savedLeavePlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLeavePlan);

    }

    // Update an existing leave plan
    @PutMapping("/{id}")
    public ResponseEntity<LeavePlan> updateLeavePlan(@PathVariable int id, @RequestBody LeavePlan leavePlan) {
        try {
            LeavePlan updatedLeavePlan = leavePlanService.updateLeavePlan(id, leavePlan);
            return ResponseEntity.ok(updatedLeavePlan);
        } catch (LeavePlanNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a leave plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeavePlan(@PathVariable int id) {
        try {
            leavePlanService.deleteLeavePlan(id);
            return ResponseEntity.noContent().build();
        } catch (LeavePlanNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<List<LeavePlan>> getLeavePlansByEmployeeId(@PathVariable int employeeId) {
        List<LeavePlan> leavePlans = leavePlanService.getLeavePlansByEmployeeId(employeeId);
        return ResponseEntity.ok(leavePlans);
    }
}

