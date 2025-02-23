package com.convertajavaobjectintojsonformat;
import org.json.JSONObject;

public class CarToJSON {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Ford", "Mustang", 2024);

        // Convert the Car object to JSON
        JSONObject carJson = car.toJSON();

        // Print the JSON output
        System.out.println(carJson.toString(4));
    }
}
