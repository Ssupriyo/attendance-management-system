package com.company.attendance.service;

import com.company.attendance.exception.InvalidAttendanceException;
import com.company.attendance.model.AttendanceRecord;
import com.company.attendance.repository.AttendanceRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AttendanceService {
    private AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public AttendanceRecord clockIn(int employeeId) {
        List<AttendanceRecord> records = attendanceRepository.findRecordsByEmployeeId(employeeId);
        for (AttendanceRecord record : records) {
            if (record.getClockOutTime() == null) {
                throw new InvalidAttendanceException("Already clocked in and not clocked out yet.");
            }
        }

        AttendanceRecord newRecord = new AttendanceRecord(
            attendanceRepository.getNextRecordId(),
            employeeId,
            LocalDateTime.now()
        );

        attendanceRepository.addRecord(newRecord);
        return newRecord;
    }

    public AttendanceRecord clockOut(int employeeId) {
        List<AttendanceRecord> records = attendanceRepository.findRecordsByEmployeeId(employeeId);

        for (AttendanceRecord record : records) {
            if (record.getClockOutTime() == null) {
                record.setClockOutTime(LocalDateTime.now());
                return record;
            }
        }

        throw new InvalidAttendanceException("No active clock-in found for clock-out.");
    }
}