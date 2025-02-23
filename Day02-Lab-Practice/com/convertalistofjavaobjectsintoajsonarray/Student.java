package com.convertalistofjavaobjectsintoajsonarray;

import org.json.JSONObject;

// This class demonstrates converting a list of Java objects into a JSON array.
class Student {
     private String name;
     private int age;

     // Constructor to initialize Student object
     public Student(String name, int age) {
          this.name = name;
          this.age = age;
     }

     // Converts a Student object to JSON format
     public JSONObject toJSON() {
          JSONObject studentJson = new JSONObject();
          studentJson.put("name", this.name);
          studentJson.put("age", this.age);
          return studentJson;
     }
}
