package com.searchforarecordincsv;

import java.io.BufferedReader;  
import java.io.FileReader;      
import java.io.IOException;     

public class CSVSearch {
    public static void main(String[] args) {
        // Specify the path to the CSV file containing employee details
        String filePath = "employees.csv";  
        // Define the name to search for in the employee records
        String searchName = "Ajeet";

        // Initialize the BufferedReader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Declare a variable to hold each line read from the file
            String line;

            // Skip the header row to avoid processing it
            br.readLine();  

            // Loop to read each line and search for the specified name
            while ((line = br.readLine()) != null) {
                // Split the line by commas to get individual fields in the array
                String[] fields = line.split(",");  

                // Check if the name in the current row matches the searchName
                if (fields[1].equalsIgnoreCase(searchName)) {
                    // Print the details of the matching record
                    System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + ", Department: " + fields[2] + ", Salary: " + fields[3]);
                }
            }
        } catch (IOException e) {
            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();  
        }
    }
}
