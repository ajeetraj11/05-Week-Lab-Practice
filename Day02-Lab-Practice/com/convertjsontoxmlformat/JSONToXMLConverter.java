package com.convertjsontoxmlformat;
import org.json.JSONObject;
import org.json.XML;

// This class converts a JSON object into XML format.
public class JSONToXMLConverter {
    public static void main(String[] args) {
        // Define a JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Ajeet");
        jsonObject.put("age", 23);
        jsonObject.put("city", "Bhopal");

        // Convert JSON to XML
        String xml = XML.toString(jsonObject);

        // Print the XML output
        System.out.println(xml);
    }
}
