package com.modifyacsvfile;

import java.io.*;  
import java.util.ArrayList;  
import java.util.List;  

// Define the class responsible for modifying employee salary in the CSV file
public class CSVSalaryUpdater {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the input file path containing employee data
        String inputFile = "employees.csv";  

        // Specify the output file path to store the updated data
        String outputFile = "updated_employees.csv";  

        // Create a list to store all employee records (updated & unchanged)
        List<String[]> records = new ArrayList<>();  

        // Initialize BufferedReader to read the input file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            // Read the first line (header) and store it separately
            String header = br.readLine();  
            records.add(header.split(","));  

            // Declare a variable to hold each line read from the file
            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {

                // Split each line into individual fields
                String[] fields = line.split(",");  

                // Check if the department is "IT"
                if (fields[2].equalsIgnoreCase("IT")) {

                    // Parse the salary, increase it by 10%, and update the field
                    double salary = Double.parseDouble(fields[3]);  
                    salary *= 1.10;  
                    fields[3] = String.format("%.2f", salary);  
                }

                // Add the updated or unchanged record to the list
                records.add(fields);
            }
        } catch (IOException e) {

            // Handle any IOExceptions that occur during file reading
            e.printStackTrace();  
        }

        // Write the modified records back to the new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Loop through the list and write each record into the output file
            for (String[] record : records) {

                // Convert the array back to a CSV-formatted line
                bw.write(String.join(",", record));  
                bw.newLine();  
            }

            // Print success message after writing is complete
            System.out.println("Updated salaries saved to: " + outputFile);
        } catch (IOException e) {

            // Handle any IOExceptions that occur during file writing
            e.printStackTrace();  
        }
    }
}
