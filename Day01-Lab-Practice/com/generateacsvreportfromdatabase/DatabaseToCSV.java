package com.generateacsvreportfromdatabase;

import java.io.*;
import java.sql.*;

// Define the class responsible for generating a CSV report from a database
public class DatabaseToCSV {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the output file path for the CSV report
        String outputFile = "employee_report.csv";

        // Define database connection details
        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String password = "password";

        // Define SQL query to fetch employee records
        String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees";

        // Initialize database connection and file writer
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Write the CSV header to the output file
            bw.write("EmployeeID,Name,Department,Salary\n");

            // Loop through the result set and write each row to the CSV file
            while (rs.next()) {
                bw.write(rs.getInt("EmployeeID") + "," +
                        rs.getString("Name") + "," +
                        rs.getString("Department") + "," +
                        rs.getDouble("Salary") + "\n");
            }

        } catch (SQLException | IOException e) {

            // Handle any database or IO exceptions that may occur
            e.printStackTrace();
        }

        // Print confirmation message after CSV generation is complete
        System.out.println("CSV report generated successfully: " + outputFile);
    }
}
