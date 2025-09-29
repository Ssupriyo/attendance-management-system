Attendance Management System (CLI)

Overview:
This is a Java-based command-line application to manage employee attendance. 
Features include:
- Clock-In and Clock-Out
- Leave Application and Approval
- Attendance and Leave Reports

Technologies Used:
- Java (Core Java)
- Maven (Build Tool)
- TestNG (Testing Framework)

Project Structure:
'''Project Structure:

attendance-management-system/
├── src/
│ ├── main/java/com/company/attendance/
│ │ ├── model/
│ │ │ ├── Employee.java
│ │ │ ├── AttendanceRecord.java
│ │ │ └── LeaveRequest.java
│ │ ├── repository/
│ │ │ ├── EmployeeRepository.java
│ │ │ └── AttendanceRepository.java
│ │ ├── service/
│ │ │ ├── AttendanceService.java
│ │ │ ├── LeaveService.java
│ │ │ └── ReportService.java
│ │ ├── exception/
│ │ │ └── InvalidAttendanceException.java
│ │ └── App.java
│ └── test/java/com/company/attendance/service/
│ ├── AttendanceServiceTest.java
│ └── LeaveServiceTest.java
├── pom.xml
└── README.md'''
How to Build and Run:
1. Build the project:
   mvn clean install

2. Run the application:
   Open App.java in Eclipse and run as Java Application

3. Run automated test cases:
   mvn test
   Or run TestNG tests directly from Eclipse

Notes:
- Attendance and leave data is stored in memory using lists and maps (no database).
- Custom exception handling is implemented.
- TestNG test cases validate core functionalities and exception handling.
