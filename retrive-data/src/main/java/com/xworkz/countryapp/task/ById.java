package com.xworkz.countryapp.task;

import java.sql.*;

public class ById {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver found");
            String url = "jdbc:mysql://localhost:3306/country";
            String username = "root";
            String password = "bhoomika#7";

            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();

            String findById = "select * from country_info where country_id = 3";

            ResultSet resultSet = statement.executeQuery(findById);
            while (resultSet.next()){
                int country_id = resultSet.getInt(1);
                String country_name = resultSet.getString(2);
                String capital = resultSet.getString(3);

                System.out.println("Country id:" + country_id + " Country Name: "+ country_name + " Country Capital: " + capital);
            }


        } catch (ClassNotFoundException | SQLException e) {
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
