package com.xworkz.jdbc.runner.library;
import java.sql.*;
import java.util.stream.StreamSupport;

public class Library {
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

            String insert1 = "insert into library values(1,'tunga','private','rajajinagar',1500)";
            String insert2 = "insert into library values(0,'yamuna','gov','shivamogga',2000)";
            String insert3 = "insert into library values(0,'kaveri','gov','coorg',25000)";
            String insert4 = "insert into library values(0,'badhra','private','badhravathi',30000)";
            String insert5 = "insert into library values(0,'krishna','gov','rajajinagar',2500)";
            String insert6 = "insert into library values(0,'kali','gov','rajajinagar',500)";
            String insert7 = "insert into library values(0,'sharavathi','gov','sagara',2100)";
            String insert8 = "insert into library values(0,'kabini','gov','mysore',14000)";
            String insert9 = "insert into library values(0,'bhima','gov','maharastra',16000)";
            String insert10 = "insert into library values(0,'ganga','gov','assam',400)";

            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);
            statement.addBatch(insert6);
            statement.addBatch(insert7);
            statement.addBatch(insert8);
            statement.addBatch(insert9);
            statement.addBatch(insert10);
            statement.executeBatch();

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
