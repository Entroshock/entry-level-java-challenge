package com.challenge.api.controller;

import com.challenge.api.model.BasicEmployee;
import com.challenge.api.model.Employee;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get all employees.
     * @return List of all employees
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Get employee by UUID.
     * @param uuid Employee UUID
     * @return Employee if found
     */
    @GetMapping("/{uuid}")
    public Employee getEmployeeByUuid(@PathVariable UUID uuid) {
        Employee employee = employeeService.getEmployeeByUuid(uuid);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    /**
     * Create a new employee.
     * @param employee Employee data from request body
     * @return Created employee with generated UUID
     */
    @PostMapping
    public Employee createEmployee(@RequestBody BasicEmployee employee) {
        // Basic validation
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "First name and last name are required");
        }

        return employeeService.createEmployee(employee);
    }
}
