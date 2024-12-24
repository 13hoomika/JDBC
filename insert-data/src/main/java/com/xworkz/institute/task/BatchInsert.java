package com.xworkz.institute.task;
import java.sql.*;

public class BatchInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver found");

            String url = "jdbc:mysql://localhost:3306/chess_championship";
            String userName = "root";
            String password = "bhoomika#7";

            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established");

            statement = connection.createStatement();

            String query1 = "INSERT INTO chess_players (player_name, country) VALUES ('R Praggnanandhaa', 'India')";
            String query2 = "INSERT INTO chess_players (player_name, country) VALUES ('Magnus Carlsen', 'Norway')";
            String query3 = "INSERT INTO chess_players (player_name, country) VALUES ('Nihal Sarin', 'India')";
            String query4 = "INSERT INTO chess_players (player_name, country) VALUES ('Vidit Gujrathi', 'India')";
            String query5 = "INSERT INTO chess_players (player_name, country) VALUES ('Fabiano Caruana', 'USA')";

            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.addBatch(query3);
            statement.addBatch(query4);
            statement.addBatch(query5);

            int[] result = statement.executeBatch();
            System.out.println(result.length + " rows inserted successfully!");

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
