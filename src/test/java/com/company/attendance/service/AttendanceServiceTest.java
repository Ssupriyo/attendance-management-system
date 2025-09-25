package com.company.attendance.service;

import com.company.attendance.exception.InvalidAttendanceException;
import com.company.attendance.model.AttendanceRecord;
import com.company.attendance.repository.AttendanceRepository;
import com.company.attendance.service.AttendanceService;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttendanceServiceTest {
    private AttendanceService attendanceService;
    private AttendanceRepository attendanceRepository;
    private int employeeId = 1;

    @BeforeMethod
    public void setUp() {
        attendanceRepository = new AttendanceRepository();
        attendanceService = new AttendanceService(attendanceRepository);
    }

    @Test
    public void testSuccessfulClockInAndClockOut() {
        AttendanceRecord record = attendanceService.clockIn(employeeId);
        Assert.assertNotNull(record.getClockInTime(), "Clock-in time should not be null");

        AttendanceRecord clockOutRecord = attendanceService.clockOut(employeeId);
        Assert.assertNotNull(clockOutRecord.getClockOutTime(), "Clock-out time should not be null");
    }

    @Test(expectedExceptions = InvalidAttendanceException.class)
    public void testDuplicateClockInThrowsException() {
        attendanceService.clockIn(employeeId);
        attendanceService.clockIn(employeeId); // Should throw exception
    }

    @Test(expectedExceptions = InvalidAttendanceException.class)
    public void testClockOutWithoutClockInThrowsException() {
        attendanceService.clockOut(employeeId); // Should throw exception
    }
}