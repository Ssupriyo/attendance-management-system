Attendance Management System (CLI)

Overview:
This is a Java-based backend command-line application to manage employee attendance. 
It supports the following features:
- Clock-In and Clock-Out for employees
- Leave Application and Approval process
- Generate Attendance and Leave reports

Technologies Used:
- Java (Core Java)
- Maven (Build Tool)
- TestNG (Testing Framework)


How to Build and Run:

1. Build the project:
   mvn clean install

2. Run the application:
   Run the App.java file from Eclipse as a Java Application.

3. Run automated test cases:
   mvn test
   Or run TestNG tests directly from Eclipse.

Notes:
- Data (attendance and leave) is stored in memory using HashMaps and Lists.
- Custom exception handling is used to manage invalid operations.
- TestNG tests cover basic functionalities and important validation scenarios.