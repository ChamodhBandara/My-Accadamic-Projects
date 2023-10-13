package com.fullstack.employee.leave.management.system.service;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import com.fullstack.employee.leave.management.system.repository.LeavePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavePlanService {
    @Autowired
    private LeavePlanRepository leavePlanRepository;

    public List<LeavePlan> getAllLeavePlans() {
        return leavePlanRepository.findAll();
    }

    public LeavePlan addLeavePlan(LeavePlan leavePlan) {
        return leavePlanRepository.save(leavePlan);
    }

    public LeavePlan updateLeavePlan(int id, LeavePlan updatedLeavePlan) {
        LeavePlan existingLeavePlan = getLeavePlanById(id);
        // Update the existing leave plan with new data
        existingLeavePlan.setEmployee(updatedLeavePlan.getEmployee());
        existingLeavePlan.setFromDate(updatedLeavePlan.getFromDate());
        existingLeavePlan.setToDate(updatedLeavePlan.getToDate());
        existingLeavePlan.setType(updatedLeavePlan.getType());
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
}
