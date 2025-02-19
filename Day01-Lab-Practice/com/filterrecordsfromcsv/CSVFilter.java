package com.filterrecordsfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFilter {
    public static void main(String[] args) {
        // Specify the path to the CSV file containing student data
        String filePath = "students.csv";

        // Initialize the BufferedReader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Declare a variable to hold each line read from the file
            String line;

            // Skip the header row to avoid processing it
            br.readLine();

            // Loop to read each line and filter records based on marks
            while ((line = br.readLine()) != null) {
                // Split line by commas into fields
                String[] fields = line.split(",");

                // Convert marks field to an integer
                int marks = Integer.parseInt(fields[3]);

                // Only print records where marks are greater than 80
                if (marks > 80) {
                    // Print the details of the students who have marks greater than 80
                    System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + ", Age: " + fields[2] + ", Marks: " + fields[3]);
                }
            }
        } catch (IOException e) {
            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();
        }
    }
}
