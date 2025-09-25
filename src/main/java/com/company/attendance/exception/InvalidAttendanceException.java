package com.company.attendance.exception;

public class InvalidAttendanceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidAttendanceException(String message) {
        super(message);
    }
}