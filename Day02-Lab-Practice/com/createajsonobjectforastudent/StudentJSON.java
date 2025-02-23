package com.createajsonobjectforastudent;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON {
    public static void main(String[] args) {
        // Create a JSON object to store student data
        JSONObject student = new JSONObject();
        
        // Add basic details to the JSON object
        student.put("name", "Ajeet");
        student.put("age", 23);
        
        // Create an array to store subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Physics");
        subjects.put("Chemistry");
        
        // Add the subjects array to the student object
        student.put("subjects", subjects);

        // Print the student JSON object
        System.out.println(student.toString(4));
    }
}
