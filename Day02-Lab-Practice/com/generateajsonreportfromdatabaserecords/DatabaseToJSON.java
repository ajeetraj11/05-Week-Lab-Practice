package com.generateajsonreportfromdatabaserecords;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

// This class fetches employee records from a database and generates a JSON report.
public class DatabaseToJSON {
    public static void main(String[] args) {
        // Define database connection details
        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String password = "password";

        // Define SQL query to fetch employee records
        String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees";

        // Initialize database connection
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Create a JSON array to hold employee records
            JSONArray employeeArray = new JSONArray();

            // Loop through the result set and convert each record to JSON
            while (rs.next()) {
                JSONObject employee = new JSONObject();
                employee.put("EmployeeID", rs.getInt("EmployeeID"));
                employee.put("Name", rs.getString("Name"));
                employee.put("Department", rs.getString("Department"));
                employee.put("Salary", rs.getDouble("Salary"));

                // Add the employee JSON object to the array
                employeeArray.put(employee);
            }

            // Print the generated JSON report
            System.out.println(employeeArray.toString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
