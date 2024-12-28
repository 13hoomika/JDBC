package com.xworkz.jdbc.runner.library;

import java.sql.*;

public class SelectOperations {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library_sys";
            String userName = "root";
            String password = "bhoomika#7";

            connection = DriverManager.getConnection(url,userName, password);
            statement = connection.createStatement();

            String findById = "Select * from library where library_id = 1";
            ResultSet resultSet = statement.executeQuery(findById);

            while (resultSet.next()){
                int library_id = resultSet.getInt(1);
                String library_name = resultSet.getString(2);
                String ownership = resultSet.getString(3);
                String location = resultSet.getString(4);
                int no_of_books = resultSet.getInt(5);

                System.out.println("library details id = 1:  ( library_id: " + library_id +
                        " library_name: " + library_name +
                        " ownership: " + ownership +
                        " location: " + location +
                        " no_of_books: " + no_of_books + ")");
            }

            String count = "select count(*) from library where location = 'rajajinagar'";
            ResultSet resultSet1 = statement.executeQuery(count);
            resultSet1.next();
            System.out.println("no of libraries located in rajajinagar: " + resultSet1.getInt(1));

            String select = "select count(*) from library where no_of_books > 10000";
            ResultSet resultSet2 = statement.executeQuery(select);
            resultSet2.next();
            System.out.println("libraries having more than 1000 books: " + resultSet2.getInt(1));

            String max = "select max(no_of_books) from library";
            ResultSet resultSet3 = statement.executeQuery(max);
            resultSet3.next();
            System.out.println("max no of books: " + resultSet3.getInt(1));


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
