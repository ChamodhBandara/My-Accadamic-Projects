package com.fullstack.employee.leave.management.system.controler;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import com.fullstack.employee.leave.management.system.service.LeavePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaveplan")
public class LeavePlanController {
    @Autowired
    private LeavePlanService leavePlanService;

    // Get all leave plans
    @GetMapping
    public List<LeavePlan> getAllLeavePlans() {
        return leavePlanService.getAllLeavePlans();
    }

    // Get a specific leave plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<LeavePlan> getLeavePlanById(@PathVariable int id) {
        LeavePlan leavePlan = leavePlanService.getLeavePlanById(id);
        return ResponseEntity.ok(leavePlan);
    }

    // Create a new leave plan
    @PostMapping
    public ResponseEntity<LeavePlan> addLeavePlan(@RequestBody LeavePlan leavePlan) {
        LeavePlan savedLeavePlan = leavePlanService.addLeavePlan(leavePlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLeavePlan);
    }

    // Update an existing leave plan
    @PutMapping("/{id}")
    public ResponseEntity<LeavePlan> updateLeavePlan(@PathVariable int id, @RequestBody LeavePlan leavePlan) {
        LeavePlan updatedLeavePlan = leavePlanService.updateLeavePlan(id, leavePlan);
        return ResponseEntity.ok(updatedLeavePlan);
    }

    // Delete a leave plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeavePlan(@PathVariable int id) {
        leavePlanService.deleteLeavePlan(id);
        return ResponseEntity.noContent().build();
    }
}

