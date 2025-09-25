package com.company.attendance.model;

public class Employee {
    // Fields (Encapsulation)
    private int employeeId;
    private String name;
    private String email;

    // Constructor
    public Employee(int employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters (to access private fields)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Simple toString() method to display Employee details
    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + ", Email=" + email + "]";
    }
}