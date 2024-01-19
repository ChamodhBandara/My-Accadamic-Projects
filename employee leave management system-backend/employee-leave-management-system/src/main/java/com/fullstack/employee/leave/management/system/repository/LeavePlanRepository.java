package com.fullstack.employee.leave.management.system.repository;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeavePlanRepository extends JpaRepository<LeavePlan, Integer> {

    List<LeavePlan> findByEmployeeId(int employeeId);
}
