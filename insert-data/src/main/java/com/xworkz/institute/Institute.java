package com.xworkz.institute;

import java.sql.*;

public class Institute {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver found");
            String url = "jdbc:mysql://localhost:3306/store";
            String userName = "root";
            String password = "bhoomika#7";

            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established");

            statement = connection.createStatement();

            // Corrected queries
            String query1 = "INSERT INTO store_info VALUES (1, 'Ashirvad')";
            String query2 = "INSERT INTO store_info VALUES (2, 'Wellness')";

            // Adding queries to batch
            statement.addBatch(query1);
            statement.addBatch(query2);

            // Executing batch
            int[] result = statement.executeBatch();
            System.out.println(result.length + " rows affected");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error during closing resources: " + e.getMessage());
            }
        }
    }
}
