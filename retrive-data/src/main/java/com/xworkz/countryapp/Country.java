package com.xworkz.countryapp;
import java.sql.*;
public class Country {
    public static void main(String[] args) {
        Connection connection =  null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver found");
            String url = "jdbc:mysql://localhost:3306/country";
            String userName = "root";
            String password = "bhoomika#7";
            connection = DriverManager.getConnection(url,userName,password);

            String insert1 = "insert into country_info values(0,'India','Delhi')";
            String insert2 = "insert into country_info values(0,'Japan','Tokyo')";
            String insert3 = "insert into country_info values(0,'Korea','Seoul')";
            String insert4 = "insert into country_info values(0,'China','Beijing')";

            statement = connection.createStatement();

            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);

            int[] row = statement.executeBatch();
            System.out.println(row.length + " rows inserted");

        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if(statement!=null){
                    statement.close();;
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }

        }


    }
}
