package com.company.attendance;

import com.company.attendance.model.AttendanceRecord;
import com.company.attendance.model.LeaveRequest;
import com.company.attendance.repository.AttendanceRepository;
import com.company.attendance.service.AttendanceService;
import com.company.attendance.service.LeaveService;
import com.company.attendance.service.ReportService;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int employeeId = 1;

        // Initialize repositories and services
        AttendanceRepository attendanceRepo = new AttendanceRepository();
        AttendanceService attendanceService = new AttendanceService(attendanceRepo);
        LeaveService leaveService = new LeaveService();
        ReportService reportService = new ReportService(attendanceRepo, leaveService);

        // Clock in and out
        attendanceService.clockIn(employeeId);
        attendanceService.clockOut(employeeId);

        // Apply and approve leave
        LeaveRequest leave = leaveService.applyForLeave(
            employeeId,
            LocalDate.of(2025, 10, 1),
            LocalDate.of(2025, 10, 5),
            "Personal leave"
        );
        leaveService.approveLeave(leave.getRequestId());

        // Generate and print attendance report
        List<AttendanceRecord> attendanceReport = reportService.generateAttendanceReport(
            employeeId,
            LocalDate.of(2025, 1, 1),
            LocalDate.of(2025, 12, 31)
        );

        System.out.println("\n--- Attendance Report ---");
        for (AttendanceRecord record : attendanceReport) {
            System.out.println(record);
        }

        // Generate and print leave report
        List<LeaveRequest> leaveReport = reportService.getLeaveReport(employeeId);

        System.out.println("\n--- Leave Report ---");
        for (LeaveRequest l : leaveReport) {
            System.out.println(l);
        }
    }
}