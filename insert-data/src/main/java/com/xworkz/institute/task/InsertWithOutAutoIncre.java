package com.xworkz.institute.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertWithOutAutoIncre {
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

            // Insert 5 rows manually
            String query1 = "INSERT INTO store_info VALUES (1, 'Ashirvad')";
            String query2 = "INSERT INTO store_info VALUES (2, 'Wellness')";
            String query3 = "INSERT INTO store_info VALUES (3, 'Reliance')";
            String query4 = "INSERT INTO store_info VALUES (4, 'D-Mart')";
            String query5 = "INSERT INTO store_info VALUES (5, 'Big Bazaar')";

            // Execute each query individually
            int result1 = statement.executeUpdate(query1);
            System.out.println(result1 + " row affected for query1");

            int result2 = statement.executeUpdate(query2);
            System.out.println(result2 + " row affected for query2");

            int result3 = statement.executeUpdate(query3);
            System.out.println(result3 + " row affected for query3");

            int result4 = statement.executeUpdate(query4);
            System.out.println(result4 + " row affected for query4");

            int result5 = statement.executeUpdate(query5);
            System.out.println(result5 + " row affected for query5");

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
