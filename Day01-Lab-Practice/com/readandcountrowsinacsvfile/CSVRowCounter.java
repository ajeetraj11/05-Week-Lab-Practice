package com.readandcountrowsinacsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounter {
    public static void main(String[] args) {
        // Specify the path to the CSV file whose rows we want to count
        String filePath = "students.csv";
        int rowCount = 0;

        // Initialize BufferedReader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header row as we want to count only data rows
            br.readLine();

            // Loop to read each line and count the number of data rows
            while ((line = br.readLine()) != null) {
                rowCount++;
            }

            // Print the total number of data rows
            System.out.println("Number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();
        }
    }
}
