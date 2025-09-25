package com.company.attendance.service;

import com.company.attendance.model.AttendanceRecord;
import com.company.attendance.model.LeaveRequest;
import com.company.attendance.repository.AttendanceRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {
    private AttendanceRepository attendanceRepository;
    private LeaveService leaveService;

    public ReportService(AttendanceRepository attendanceRepository, LeaveService leaveService) {
        this.attendanceRepository = attendanceRepository;
        this.leaveService = leaveService;
    }

    // Generate attendance report for an employee within a date range
    public List<AttendanceRecord> generateAttendanceReport(int employeeId, LocalDate fromDate, LocalDate toDate) {
        return attendanceRepository.findRecordsByEmployeeId(employeeId)
                .stream()
                .filter(record -> {
                    LocalDate clockInDate = record.getClockInTime().toLocalDate();
                    return (clockInDate.isEqual(fromDate) || clockInDate.isAfter(fromDate)) &&
                           (clockInDate.isEqual(toDate) || clockInDate.isBefore(toDate));
                })
                .collect(Collectors.toList());
    }

    // Get leave report for an employee
    public List<LeaveRequest> getLeaveReport(int employeeId) {
        return leaveService.getLeaveRequestsForEmployee(employeeId);
    }
}