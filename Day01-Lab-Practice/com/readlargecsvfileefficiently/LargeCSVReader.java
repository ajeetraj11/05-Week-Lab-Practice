package com.readlargecsvfileefficiently;

import java.io.*;  

// Define the class responsible for efficiently reading large CSV files
public class LargeCSVReader {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the file path of the large CSV file
        String filePath = "large_dataset.csv";  

        // Define the chunk size (number of lines to process at a time)
        int chunkSize = 100;  

        // Initialize a counter to track the number of records processed
        int recordCount = 0;  

        // Initialize BufferedReader to read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read and ignore the first line (header)
            br.readLine();  

            // Declare a variable to hold each line read from the file
            String line;  

            // Read the file line by line
            while ((line = br.readLine()) != null) {

                // Increment the record counter
                recordCount++;  

                // Print the line (or process as needed)
                System.out.println(line);  

                // If the chunk size is reached, display progress and pause processing
                if (recordCount % chunkSize == 0) {
                    System.out.println("Processed " + recordCount + " records so far...");
                }
            }
        } catch (IOException e) {

            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();  
        }

        // Print the final count of records processed
        System.out.println("Total records processed: " + recordCount);  
    }
}
