package com.company.attendance.service;

import com.company.attendance.model.LeaveRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeaveService {
    private List<LeaveRequest> leaveRequests = new ArrayList<>();
    private int requestCounter = 1;

    // Apply for leave
    public LeaveRequest applyForLeave(int employeeId, LocalDate startDate, LocalDate endDate, String reason) {
        if (endDate.isBefore(startDate)) {
            throw new RuntimeException("End date cannot be before start date.");
        }

        LeaveRequest request = new LeaveRequest(requestCounter++, employeeId, startDate, endDate, reason);
        leaveRequests.add(request);
        return request;
    }

    // Approve leave request
    public void approveLeave(int requestId) {
        for (LeaveRequest req : leaveRequests) {
            if (req.getRequestId() == requestId) {
                req.approve();
                return;
            }
        }
        throw new RuntimeException("Leave request not found.");
    }

    // Get leave requests by employee
    public List<LeaveRequest> getLeaveRequestsForEmployee(int employeeId) {
        List<LeaveRequest> result = new ArrayList<>();
        for (LeaveRequest req : leaveRequests) {
            if (req.getEmployeeId() == employeeId) {
                result.add(req);
            }
        }
        return result;
    }
}