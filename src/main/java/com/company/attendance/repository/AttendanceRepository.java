package com.company.attendance.repository;

import com.company.attendance.model.AttendanceRecord;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository {
    private List<AttendanceRecord> records = new ArrayList<>();
    private int recordCounter = 1;

    // Add a new attendance record
    public void addRecord(AttendanceRecord record) {
        records.add(record);
    }

    // Find all records by employee ID
    public List<AttendanceRecord> findRecordsByEmployeeId(int employeeId) {
        List<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord record : records) {
            if (record.getEmployeeId() == employeeId) {
                result.add(record);
            }
        }
        return result;
    }

    // Generate a new record ID
    public int getNextRecordId() {
        return recordCounter++;
    }
}