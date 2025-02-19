package com.validatecsvdatabeforeprocessing;

import java.io.*;  
import java.util.regex.*;  

// Define the class responsible for validating CSV data before processing
public class CSVDataValidator {

    // Define a regular expression pattern for validating email addresses
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";  

    // Define a regular expression pattern for validating phone numbers (10 digits)
    private static final String PHONE_REGEX = "^[0-9]{10}$";  

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the file path of the CSV file
        String filePath = "employees.csv";  

        // Initialize BufferedReader to read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read the first line (header) and display it
            String header = br.readLine();  
            System.out.println("Header: " + header);  

            // Declare a variable to hold each line read from the file
            String line;  

            // Read the file line by line
            while ((line = br.readLine()) != null) {

                // Split the line into individual fields
                String[] fields = line.split(",");  

                // Extract email and phone number from the relevant columns
                String email = fields[2];  
                String phone = fields[3];  

                // Validate the email format using regex
                boolean isEmailValid = Pattern.matches(EMAIL_REGEX, email);  

                // Validate the phone number format using regex
                boolean isPhoneValid = Pattern.matches(PHONE_REGEX, phone);  

                // If both email and phone number are valid, display the record
                if (isEmailValid && isPhoneValid) {
                    System.out.println("Valid Record: " + line);  
                } else {

                    // Print an error message if the record is invalid
                    System.out.println("Invalid Record: " + line);  

                    // Indicate which field is incorrect
                    if (!isEmailValid) {
                        System.out.println(" -> Invalid Email Format: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println(" -> Invalid Phone Number: " + phone);
                    }
                }
            }
        } catch (IOException e) {

            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();  
        }
    }
}
