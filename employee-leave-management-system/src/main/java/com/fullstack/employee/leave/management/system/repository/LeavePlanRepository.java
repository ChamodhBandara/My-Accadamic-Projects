package com.fullstack.employee.leave.management.system.repository;

import com.fullstack.employee.leave.management.system.model.LeavePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavePlanRepository extends JpaRepository<LeavePlan, Integer> {
}
