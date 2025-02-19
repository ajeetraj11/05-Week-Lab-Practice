package com.convertcsvdataintojavaobjects;

import java.io.*;  
import java.util.*;  

// Define a Student class to hold student details
class Student {

    // Declare fields for student details
    private int id;  
    private String name;  
    private int age;  

    // Constructor to initialize a Student object
    public Student(int id, String name, int age) {
        this.id = id;  
        this.name = name;  
        this.age = age;  
    }

    // Override the toString() method to return a formatted student string
    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age;  
    }
}

// Define the class responsible for converting CSV data into Student objects
public class CSVToJavaObjects {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify the file path of the CSV file
        String filePath = "students.csv";  

        // Create a list to store Student objects
        List<Student> studentList = new ArrayList<>();  

        // Initialize BufferedReader to read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read and ignore the first line (header)
            br.readLine();  

            // Declare a variable to hold each line read from the file
            String line;  

            // Read the file line by line
            while ((line = br.readLine()) != null) {

                // Split the line into individual fields
                String[] fields = line.split(",");  

                // Extract student details and create a new Student object
                int id = Integer.parseInt(fields[0]);  
                String name = fields[1];  
                int age = Integer.parseInt(fields[2]);  
                Student student = new Student(id, name, age);  

                // Add the student object to the list
                studentList.add(student);  
            }
        } catch (IOException e) {

            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();  
        }

        // Print all Student objects stored in the list
        System.out.println("Student List:");
        for (Student student : studentList) {
            System.out.println(student);  
        }
    }
}
