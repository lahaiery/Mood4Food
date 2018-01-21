package com.example.ryanr.spartahack;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liamb on 1/21/2018.
 * Allows views and fragments to access database information via web server
 */

public class DatabaseGetter {
    final static private String baseURL = "google.com/";

    public static String getMeals() {
        String page = "meal";
        try {
            URL fullURL = new URL(baseURL + page);
            HttpURLConnection connection = (HttpURLConnection) fullURL.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode(); // Response code should be 200
            return Integer.toString(responseCode);
        }
        catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
