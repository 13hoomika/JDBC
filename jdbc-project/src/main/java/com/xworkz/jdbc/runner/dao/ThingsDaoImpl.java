package com.xworkz.jdbc.runner.dao;
import java.sql.*;

import com.xworkz.jdbc.runner.dto.ThingsDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThingsDaoImpl implements ThingsDao{
    Connection connection = null;
    PreparedStatement preparedStatement= null;

    @Override
    public int save(String title, String author, String genres) {
        String url = "jdbc:mysql://localhost:3306/library_sys";
        String user = "root";
        String pass = "bhoomika#7";
        try {
            connection = DriverManager.getConnection(url,user,pass);
            preparedStatement = connection.prepareStatement("insert into things value(?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,author);
            preparedStatement.setString(4,genres);
            int row = preparedStatement.executeUpdate();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public ResultSet getAllData() {
        String url = "jdbc:mysql://localhost:3306/library_sys";
        String user = "root";
        String pass = "bhoomika#7";

        try {
            connection= DriverManager.getConnection(url,user,pass);
            System.out.println("connected");
            preparedStatement = connection.prepareStatement("select * from things");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
