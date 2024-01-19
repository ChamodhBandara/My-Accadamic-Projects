package com.fullstack.employee.leave.management.system.repository;

import com.fullstack.employee.leave.management.system.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByEmpNo(String empNo, Pageable pageable);

    Page<Employee> findByEmail(String email, Pageable pageable);



}

