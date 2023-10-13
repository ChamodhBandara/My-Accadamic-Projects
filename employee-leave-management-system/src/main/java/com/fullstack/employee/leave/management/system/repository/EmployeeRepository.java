package com.fullstack.employee.leave.management.system.repository;

import com.fullstack.employee.leave.management.system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
