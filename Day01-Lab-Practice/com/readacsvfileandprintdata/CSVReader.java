package com.readacsvfileandprintdata;

// Import necessary classes for file reading
import java.io.BufferedReader;   
import java.io.FileReader;       
import java.io.IOException;      

// Define the class to handle CSV reading
public class CSVReader {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the path to the CSV file to be read
        String filePath = "students.csv";  

        // Initialize a BufferedReader to read from the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Declare a variable to hold each line read from the file
            String line;

            // Loop through the file line by line until the end is reached
            while ((line = br.readLine()) != null) {

                // Split the line by commas to separate the columns in the CSV
                String[] fields = line.split(",");  

                // Print the student data in a structured format
                System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + ", Age: " + fields[2] + ", Marks: " + fields[3]);
            }
        } catch (IOException e) {

            // Print any errors that occur during the file reading process
            e.printStackTrace();  
        }
    }
}
