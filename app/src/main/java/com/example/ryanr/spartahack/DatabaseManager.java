package com.example.ryanr.spartahack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by liamb on 1/20/2018.
 * Connects to PostgreSQL database and provides interface for retrieving info from database
 */

public class DatabaseManager {
    private Connection c;

    /**
     *  Constructor
     *  Create connection to PostgreSQL db
     */
    public DatabaseManager() {
        // Connect to PostgreSQL db
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "postgres://zuptntbeyfahuc:aa1b6e72bb23de35245ed2bb5a58be1671e51fab36942e2be569f65eeae2674b@ec2-54-243-193-227.compute-1.amazonaws.com:5432/da24i8fioenidl",
                    "postgres", "123");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public String GetDish() {
        String result = "";
        try {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("Select name from dishes;");
            while (resultSet.next()) {
                result += resultSet.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return result;
    }
}
