package com.fullstack.employee.leave.management.system.controler;
import com.fullstack.employee.leave.management.system.model.Employee;
import com.fullstack.employee.leave.management.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.domain.Pageable;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/paged")
    public ResponseEntity<List<Employee>> getEmployeesPaged(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "8") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeService.getEmployeesPaged(pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Pages", Integer.toString(employeePage.getTotalPages()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(employeePage.getContent());
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get a specific employee by ID

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById( id);
        return ResponseEntity.ok(employee);
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        // If the employee has an email, send a notification
        if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
            employeeService.sendEmailNotification(employee);
        }

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee( id, employee);
        // If the employee has an email, send a notification
        if (updatedEmployee.getEmail() != null && !updatedEmployee.getEmail().isEmpty()) {
            employeeService.sendEmailNotification(updatedEmployee);
        }

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> employeeExistsById(@PathVariable int id) {
        boolean exists = employeeService.employeeExistsById(id);
        return ResponseEntity.ok(exists);
    }



}

