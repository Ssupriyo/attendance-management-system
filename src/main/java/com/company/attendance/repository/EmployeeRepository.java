package com.company.attendance.repository;

import com.company.attendance.model.Employee;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {
    // In-memory storage using HashMap
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    // Add a new employee
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeId(), employee);
    }

    // Find an employee by ID
    public Employee findEmployeeById(int employeeId) {
        return employeeMap.get(employeeId);
    }

    // Get all employees
    public Map<Integer, Employee> getAllEmployees() {
        return employeeMap;
    }
}