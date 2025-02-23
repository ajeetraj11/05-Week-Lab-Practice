package com.parsejsonandfilteronlythoserecords;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.*;

// This class reads a JSON file and filters records where age is greater than 25.
public class FilterJSONByAge {
    public static void main(String[] args) {
        try {
            // Read JSON file content as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get("users.json")));

            // Convert JSON string to JSONArray
            JSONArray users = new JSONArray(jsonContent);

            // Filter and print users with age > 25
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                if (user.getInt("age") > 25) {
                    System.out.println(user.toString(4));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
