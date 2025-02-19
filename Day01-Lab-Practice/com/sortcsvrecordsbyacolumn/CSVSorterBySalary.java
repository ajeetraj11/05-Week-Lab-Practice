package com.sortcsvrecordsbyacolumn;

import java.io.*;  
import java.util.*;  

// Define the class responsible for sorting CSV records by salary
public class CSVSorterBySalary {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the file path of the CSV file
        String filePath = "employees.csv";  

        // Create a list to store all records
        List<String[]> records = new ArrayList<>();  

        // Initialize BufferedReader to read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read and store the header row separately
            String header = br.readLine();  
            records.add(header.split(","));  

            // Declare a variable to hold each line read from the file
            String line;

            // Read and store all data rows in the list
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
        } catch (IOException e) {

            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();  
        }

        // Sort the employee records by salary in descending order
        Collections.sort(records.subList(1, records.size()), (r1, r2) -> Double.compare(Double.parseDouble(r2[3]), Double.parseDouble(r1[3])));

        // Print the top 5 highest-paid employees
        System.out.println("Top 5 highest-paid employees:");
        for (int i = 1; i <= Math.min(5, records.size() - 1); i++) {

            // Print the employee details in formatted output
            System.out.println(String.join(", ", records.get(i)));  
        }
    }
}
