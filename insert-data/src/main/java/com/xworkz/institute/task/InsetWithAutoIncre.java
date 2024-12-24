package com.xworkz.institute.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsetWithAutoIncre {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver found");
            String url = "jdbc:mysql://localhost:3306/institute";
            String userName = "root";
            String password = "bhoomika#7";

            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established");

            statement = connection.createStatement();

            // Insert 10 rows into the table
            String query1 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('X-Workz', 'Java')";
            String query2 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('CodeAcademy', 'Python')";
            String query3 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('SkillShare', 'Data Science')";
            String query4 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('Udemy', 'Machine Learning')";
            String query5 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('Coursera', 'AI')";
            String query6 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('Pluralsight', 'Cybersecurity')";
            String query7 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('LinkedIn Learning', 'Web Development')";
            String query8 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('Edureka', 'Cloud Computing')";
            String query9 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('Khan Academy', 'Mathematics')";
            String query10 = "INSERT INTO institute_info (institute_name, course_name) VALUES ('Simplilearn', 'DevOps')";

            // Execute each query individually
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            statement.executeUpdate(query4);
            statement.executeUpdate(query5);
            statement.executeUpdate(query6);
            statement.executeUpdate(query7);
            statement.executeUpdate(query8);
            statement.executeUpdate(query9);
            statement.executeUpdate(query10);

            System.out.println("10 rows inserted successfully!");

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
