package com.xworkz.jdbc.runner.preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementRunner {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        String url = "jdbc:mysql://localhost:3306/library_sys";
        String userName = "root";
        String password = "bhoomika#7";

        try {
            connection = DriverManager.getConnection(url,userName, password);
            String query = "insert into things value(?,?,?,?)";

            statement = connection.prepareStatement(query);
            statement.setInt(1,1);
            statement.setString(2,"The Women");
            statement.setString(3,"Kristin Hannah");
            statement.setString(4,"Historical Fiction");

            //2nd row
//            statement.setInt(1,0);
//            statement.setString(2,"Funny Story");
//            statement.setString(3,"Emily Henry");
//            statement.setString(4,"Fiction");

            int rows = statement.executeUpdate();
            System.out.println(rows + " rows inserted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }if (statement != null){
                    statement.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
