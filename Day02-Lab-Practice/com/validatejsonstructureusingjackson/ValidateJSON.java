package com.validatejsonstructureusingjackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJSON {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file and parse it into JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File("students.json"));

            // Validate that required fields exist
            if (jsonNode.has("name") && jsonNode.has("age")) {
                System.out.println("Valid JSON structure.");
            } else {
                System.out.println("Invalid JSON structure.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
