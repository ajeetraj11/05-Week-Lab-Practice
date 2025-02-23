package com.convertalistofjavaobjectsintoajsonarray;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ListToJSONArray {
    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ajeet", 22));
        students.add(new Student("Amit", 21));
        students.add(new Student("Ankit", 20));

        // Convert list of students to a JSON array
        JSONArray studentArray = new JSONArray();
        for (Student student : students) {
            studentArray.put(student.toJSON());
        }

        // Print the JSON array
        System.out.println(studentArray.toString(4));
    }
}
