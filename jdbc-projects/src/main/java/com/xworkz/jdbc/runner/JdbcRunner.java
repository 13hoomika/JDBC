package com.xworkz.jdbc.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load and register the driver
            String url = "jdbc:mysql://localhost:3306/laptop";
            String userName = "root";
            String password = "bH00m1k@";

            connection = DriverManager.getConnection(url, userName, password);

            statement = connection.createStatement();
            String query = "insert into laptop_info (brand_name,price) values('Lenovo',15000)";
            String query1 = "insert into laptop_info values(0,'MSI',19000)";
            String query2 = "insert into laptop_info values(0,'Mac',55000)";
            String query3 = "insert into laptop_info values(0,'mi',28000)";

            //batch update
            statement.addBatch(query);
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.addBatch(query3);

            int[] result = statement.executeBatch();
            System.out.println(result.length + "row affected");


            System.out.println("Connection is successfully");
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
