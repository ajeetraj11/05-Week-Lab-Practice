package com.convertalistofjavaobjectsintoajsonarrayjavacopyedit;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

// This class demonstrates converting a list of Java objects into a JSON array.
class Product {
    private String name;
    private double price;

    // Constructor to initialize Product object
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Converts a Product object to JSON format
    public JSONObject toJSON() {
        JSONObject productJson = new JSONObject();
        productJson.put("name", this.name);
        productJson.put("price", this.price);
        return productJson;
    }
}

public class ListToJSONArray {
    public static void main(String[] args) {
        // Create a list of Product objects
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1590.99));
        products.add(new Product("Phone", 899.49));

        // Convert list of products to a JSON array
        JSONArray productArray = new JSONArray();
        for (Product product : products) {
            productArray.put(product.toJSON());
        }

        // Print the JSON array
        System.out.println(productArray.toString(4));
    }
}
