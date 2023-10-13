package com.fullstack.employee.leave.management.system.service;

import com.fullstack.employee.leave.management.system.model.Employee;
import com.fullstack.employee.leave.management.system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        // Update the existing employee with new data
        existingEmployee.setEmpNo(updatedEmployee.getEmpNo());
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setDob(updatedEmployee.getDob());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        // Save and return the updated employee
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee = getEmployeeById(id);
        // Delete the employee
        employeeRepository.delete(existingEmployee);
    }
}

