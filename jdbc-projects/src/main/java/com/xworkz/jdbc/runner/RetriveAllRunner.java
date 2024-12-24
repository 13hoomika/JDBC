package com.xworkz.jdbc.runner;

import java.sql.*;

public class RetriveAllRunner {
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
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int laptopId = resultSet.getInt(1);
                String laptopBrand = resultSet.getNString(2);
                int laptopPrice = resultSet.getInt(3);

                System.out.println("Laptop Id: " + laptopId +
                        " Laptop Brand: " + laptopBrand +
                        " Laptop Price: " + laptopPrice);
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
