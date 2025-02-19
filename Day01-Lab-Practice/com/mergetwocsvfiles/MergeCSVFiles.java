package com.mergetwocsvfiles;

import java.io.*;  
import java.util.*;  

// Define the class responsible for merging two CSV files
public class MergeCSVFiles {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the file paths of the two CSV files
        String file1 = "students1.csv";  
        String file2 = "students2.csv";  
        String outputFile = "merged_students.csv";  

        // Create a HashMap to store student details from the first file
        Map<String, String[]> studentData = new HashMap<>();  

        // Read the first CSV file and store data in HashMap
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {

            // Read and ignore the first line (header)
            br.readLine();  

            // Declare a variable to hold each line read from the file
            String line;  

            // Read the file line by line
            while ((line = br.readLine()) != null) {

                // Split the line into individual fields
                String[] fields = line.split(",");  

                // Store the student data using ID as the key
                studentData.put(fields[0], fields);  
            }
        } catch (IOException e) {

            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();  
        }

        // Read the second CSV file and merge data
        try (BufferedReader br = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Read the first line (header) and write merged header to output file
            String header = br.readLine();  
            bw.write("ID,Name,Age,Marks,Grade\n");  

            // Declare a variable to hold each line read from the file
            String line;  

            // Read the file line by line
            while ((line = br.readLine()) != null) {

                // Split the line into individual fields
                String[] fields = line.split(",");  

                // Retrieve student details from the first CSV file using ID
                if (studentData.containsKey(fields[0])) {
                    String[] studentDetails = studentData.get(fields[0]);  

                    // Merge data from both files and write to the new CSV file
                    bw.write(studentDetails[0] + "," + studentDetails[1] + "," + studentDetails[2] + "," +
                            fields[1] + "," + fields[2] + "\n");  
                }
            }
        } catch (IOException e) {

            // Handle any IOExceptions that may occur during file writing
            e.printStackTrace();  
        }

        // Print confirmation message after merging is complete
        System.out.println("CSV files merged successfully into: " + outputFile);  
    }
}
