package com.readajsonfileandprintallkeysandvalues;

import org.json.JSONObject;
import java.nio.file.*;
import java.util.Iterator;

// This class reads a JSON file and prints all keys and values.
public class PrintJSONKeysValues {
    public static void main(String[] args) {
        try {
            // Read JSON file content as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get("data.json")));

            // Convert string into JSON object
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Iterate through keys and print key-value pairs
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                System.out.println(key + ": " + jsonObject.get(key));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
