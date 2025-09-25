package com.company.attendance.model;

import java.time.LocalDateTime;

public class AttendanceRecord {
    private int recordId;
    private int employeeId;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;

    public AttendanceRecord(int recordId, int employeeId, LocalDateTime clockInTime) {
        this.recordId = recordId;
        this.employeeId = employeeId;
        this.clockInTime = clockInTime;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getClockInTime() {
        return clockInTime;
    }

    public LocalDateTime getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(LocalDateTime clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

    @Override
    public String toString() {
        return "AttendanceRecord [RecordID=" + recordId + ", EmployeeID=" + employeeId +
               ", ClockIn=" + clockInTime + ", ClockOut=" + clockOutTime + "]";
    }
}