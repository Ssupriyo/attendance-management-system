package com.company.attendance.service;

import com.company.attendance.model.LeaveRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class LeaveServiceTest {
    private LeaveService leaveService;
    private int employeeId = 1;

    @BeforeMethod
    public void setUp() {
        leaveService = new LeaveService();
    }

    @Test
    public void testApplyAndApproveLeave() {
        LeaveRequest leave = leaveService.applyForLeave(
            employeeId,
            LocalDate.of(2025, 10, 1),
            LocalDate.of(2025, 10, 5),
            "Vacation"
        );

        Assert.assertEquals(leave.getStatus(), "PENDING");

        leaveService.approveLeave(leave.getRequestId());

        List<LeaveRequest> leaves = leaveService.getLeaveRequestsForEmployee(employeeId);
        Assert.assertEquals(leaves.size(), 1);
        Assert.assertEquals(leaves.get(0).getStatus(), "APPROVED");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testInvalidDateRangeThrowsException() {
        leaveService.applyForLeave(
            employeeId,
            LocalDate.of(2025, 10, 5),
            LocalDate.of(2025, 10, 1),
            "Invalid range"
        );
    }
}