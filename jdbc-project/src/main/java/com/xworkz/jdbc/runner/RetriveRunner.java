package com.xworkz.jdbc.runner;

import java.sql.*;

public class RetriveRunner {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load and register the driver
            String url = "jdbc:mysql://localhost:3306/laptop";
            String userName = "root";
            String password = "bhoomika#7";

            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();

            String query = "Select * from laptop_info";
//            String findById = "Select * from laptop_info where laptop_id = 1";
            ResultSet resultSet = statement.executeQuery(query);

            //row 1 data
            resultSet.next();
            System.out.println("Laptop Id: "+ resultSet.getInt(1));

            resultSet.next();//row 2 data
            System.out.println("Laptop id: "+resultSet.getInt(1)+
                    " Brand name: " + resultSet.getString(2) +
                    " Price: "+resultSet.getInt(3));

            resultSet.next(); //row 3 data
            System.out.println("Laptop Id: "+ resultSet.getInt(1) +
                    " Brand name: " + resultSet.getString(2) +
                    " Price: "+resultSet.getInt(3));


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
