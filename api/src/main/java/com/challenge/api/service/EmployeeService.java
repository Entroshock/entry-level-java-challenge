package com.challenge.api.service;

import com.challenge.api.model.BasicEmployee;
import com.challenge.api.model.Employee;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 * Service class for handling employee operations.
 * Uses in-memory storage with mock data.
 */
@Service
public class EmployeeService {

    private Map<UUID, Employee> employees = new HashMap<>();

    public EmployeeService() {
        initializeMockEmployees();
    }

    private void initializeMockEmployees() {
        createMockEmployee("Alex", "Tsang", "alex.tsang@company.com", "Graduate Engineer", 35000, 29);
        createMockEmployee("Jane", "Smith", "jane.smith@company.com", "Product Manager", 95000, 32);
        createMockEmployee("Patrick", "Johnson", "patrick.j@company.com", "Senior Staff Engineer", 105000, 35);
    }

    private void createMockEmployee(
            String firstName, String lastName, String email, String jobTitle, Integer salary, Integer age) {
        BasicEmployee employee = new BasicEmployee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setJobTitle(jobTitle);
        employee.setSalary(salary);
        employee.setAge(age);

        // Generate and set UUID
        UUID uuid = UUID.randomUUID();
        employee.setUuid(uuid);

        employees.put(uuid, employee);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.get(uuid);
    }

    public Employee createEmployee(Employee employee) {
        UUID uuid = UUID.randomUUID();
        employee.setUuid(uuid);

        employees.put(uuid, employee);

        return employee;
    }
}
