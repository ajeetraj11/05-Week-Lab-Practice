package com.convertjsontocsvandviceversa;

import java.io.*;
import org.json.*;
import java.nio.file.*;

// Define the class responsible for converting between JSON and CSV formats
public class JSONCSVConverter {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // Specify input JSON file and output CSV file paths
        String jsonFile = "students.json";
        String csvFile = "students.csv";

        // Convert JSON to CSV
        convertJsonToCsv(jsonFile, csvFile);

        // Convert CSV back to JSON
        convertCsvToJson(csvFile, "converted_students.json");
    }

    // Method to convert JSON data to CSV format
    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        try {

            // Read JSON file content as a string
            String jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Convert JSON string to a JSONArray object
            JSONArray jsonArray = new JSONArray(jsonData);

            // Initialize BufferedWriter to write to CSV file
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath));

            // Write CSV header based on JSON keys
            JSONObject firstObject = jsonArray.getJSONObject(0);
            bw.write(String.join(",", firstObject.keySet()) + "\n");

            // Write each JSON object as a CSV row
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                bw.write(obj.getInt("ID") + "," + obj.getString("Name") + "," + obj.getInt("Age") + "\n");
            }

            // Close BufferedWriter
            bw.close();

            // Print confirmation message after CSV conversion is complete
            System.out.println("JSON successfully converted to CSV: " + csvFilePath);

        } catch (IOException | JSONException e) {

            // Handle any JSON or IO exceptions that may occur
            e.printStackTrace();
        }
    }

    // Method to convert CSV data back to JSON format
    public static void convertCsvToJson(String csvFilePath, String jsonFilePath) {
        try {

            // Initialize BufferedReader to read the CSV file
            BufferedReader br = new BufferedReader(new FileReader(csvFilePath));

            // Read and store the CSV header
            String[] headers = br.readLine().split(",");

            // Create a JSONArray to hold JSON objects
            JSONArray jsonArray = new JSONArray();

            // Read CSV file line by line
            String line;
            while ((line = br.readLine()) != null) {

                // Split line into values
                String[] values = line.split(",");

                // Create a JSONObject for each row
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }

                // Add JSON object to JSONArray
                jsonArray.put(obj);
            }

            // Close BufferedReader
            br.close();

            // Write JSON data to output file
            Files.write(Paths.get(jsonFilePath), jsonArray.toString(4).getBytes());

            // Print confirmation message after JSON conversion is complete
            System.out.println("CSV successfully converted to JSON: " + jsonFilePath);

        } catch (IOException | JSONException e) {

            // Handle any JSON or IO exceptions that may occur
            e.printStackTrace();
        }
    }
}
