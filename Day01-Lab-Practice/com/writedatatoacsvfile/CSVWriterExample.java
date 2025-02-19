package com.writedatatoacsvfile;

// Import necessary classes for file writing and CSV handling
import java.io.FileWriter;  
import java.io.IOException;  
import com.opencsv.CSVWriter;  

// Define the class responsible for writing CSV data
public class CSVWriterExample {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the path where the CSV file will be created
        String filePath = "employee_details.csv";  

        // Initialize CSVWriter to write to the specified file
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            // Define the header of the CSV file with column names
            String[] header = {"ID", "Name", "Department", "Salary"};
            
            // Write the header to the CSV file
            writer.writeNext(header);  

            // Define employee records and write them to the file
            String[] employee1 = {"1", "Ajeet", "IT", "80000"};
            writer.writeNext(employee1);  

            String[] employee2 = {"2", "Ankit", "HR", "62000"};
            writer.writeNext(employee2);  

            String[] employee3 = {"3", "Vishal", "Finance", "65000"};
            writer.writeNext(employee3);  

            String[] employee4 = {"4", "Abhishek", "IT", "75000"};
            writer.writeNext(employee4);  

            String[] employee5 = {"5", "Vishal", "HR", "48000"};
            writer.writeNext(employee5);  
        } catch (IOException e) {

            // Handle any IOExceptions that occur during file writing
            e.printStackTrace();  
        }
    }
}
