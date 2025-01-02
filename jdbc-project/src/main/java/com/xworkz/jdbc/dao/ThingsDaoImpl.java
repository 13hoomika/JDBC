package com.xworkz.jdbc.dao;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThingsDaoImpl implements ThingsDao{
    Connection connection = null;
    PreparedStatement preparedStatement= null;

    private final String URL = "jdbc:mysql://localhost:3306/library_sys";
    private final String USER = "root";
    private final String PASS = "bhoomika#7";

    @Override
    public int save(String title, String author, String genres) {

        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
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
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            System.out.println("connected");
            preparedStatement = connection.prepareStatement("select * from things");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public ResultSet getById(int id) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            preparedStatement = connection.prepareStatement("select * from things where book_id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getActiveThings(boolean isACtive) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            System.out.println("connected");
            preparedStatement = connection.prepareStatement("select * from things where flag_isActive = ?");
            preparedStatement.setBoolean(1,isACtive);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public int updateById(String genres,String author,int id) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            preparedStatement = connection.prepareStatement("update things set genres = ?, author = ? where book_id = ?");
            connection.setAutoCommit(false);
            preparedStatement.setString(1,genres);
            preparedStatement.setString(2,author);
            preparedStatement.setInt(3,id);
            int row = preparedStatement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return 0;
    }

    @Override
    public int onDeleteById(int id) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            preparedStatement = connection.prepareStatement("delete from things where book_id = ?");
            connection.setAutoCommit(false);
            preparedStatement.setInt(1,id);
            int row = preparedStatement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return 0;
    }
}
