package com.mergetwojsonfilesintoasinglejsonobject;
import org.json.JSONObject;
import java.nio.file.*;

// This class reads two JSON files and merges them into a single JSON object.
public class MergeJSONFiles {
    public static void main(String[] args) {
        try {
            // Read both JSON files
            String jsonContent1 = new String(Files.readAllBytes(Paths.get("file1.json")));
            String jsonContent2 = new String(Files.readAllBytes(Paths.get("file2.json")));

            // Convert both JSON strings to JSONObject
            JSONObject json1 = new JSONObject(jsonContent1);
            JSONObject json2 = new JSONObject(jsonContent2);

            // Merge json2 into json1
            for (String key : JSONObject.getNames(json2)) {
                json1.put(key, json2.get(key));
            }

            // Print the merged JSON object
            System.out.println(json1.toString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
