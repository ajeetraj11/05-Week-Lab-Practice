package com.validateanemailfieldusingjsonschema;
import org.everit.json.schema.*;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

// This class validates an email field in a JSON object using JSON Schema.
public class ValidateEmailField {
    public static void main(String[] args) {
        // Define a JSON schema for email validation
        String schemaString = "{ 'type': 'object', 'properties': { 'email': { 'type': 'string', 'format': 'email' } }, 'required': ['email'] }".replace("'", "\"");

        // Define a JSON object with an email field
        String jsonString = "{ 'email': 'test@example.com' }".replace("'", "\"");

        try {
            // Convert schema and JSON string into JSONObject
            JSONObject schemaJson = new JSONObject(schemaString);
            JSONObject json = new JSONObject(jsonString);

            // Load and validate JSON schema
            Schema schema = SchemaLoader.load(schemaJson);
            schema.validate(json);

            System.out.println("Valid email format!");

        } catch (ValidationException e) {
            System.out.println("Invalid email: " + e.getMessage());
        }
    }
}
