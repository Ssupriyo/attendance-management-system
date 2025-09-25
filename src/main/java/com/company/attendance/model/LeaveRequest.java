package com.company.attendance.model;

import java.time.LocalDate;

public class LeaveRequest {
    private int requestId;
    private int employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // PENDING, APPROVED, REJECTED
    private String reason;

    public LeaveRequest(int requestId, int employeeId, LocalDate startDate, LocalDate endDate, String reason) {
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = "PENDING";
    }

    public int getRequestId() {
        return requestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public void approve() {
        this.status = "APPROVED";
    }

    public void reject() {
        this.status = "REJECTED";
    }

    @Override
    public String toString() {
        return "LeaveRequest [RequestID=" + requestId + ", EmployeeID=" + employeeId +
               ", Start=" + startDate + ", End=" + endDate + ", Status=" + status + ", Reason=" + reason + "]";
    }
}