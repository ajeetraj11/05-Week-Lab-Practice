package com.convertajavaobjectintojsonformat;

import org.json.JSONObject;

class Car {
     private String brand;
     private String model;
     private int year;

     // Constructor to initialize the Car object
     public Car(String brand, String model, int year) {
          this.brand = brand;
          this.model = model;
          this.year = year;
     }

     // Method to convert Car object to JSON format
     public JSONObject toJSON() {
          JSONObject carJson = new JSONObject();
          carJson.put("brand", this.brand);
          carJson.put("model", this.model);
          carJson.put("year", this.year);
          return carJson;
     }
}
