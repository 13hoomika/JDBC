package com.xworkz.weather.dao;

import com.xworkz.weather.dto.Dto;

import java.sql.*;

public class DaoImpl implements Dao {
    Connection connection = null;
    PreparedStatement statement= null;

    final String URL = "jdbc:mysql://localhost:3306/country";
    final String USER = "root";
    final String PASS = "bhoomika#7";

    @Override
    public int insertNews(Dto dto) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("insert into news_table (headline, source, Date, Category, Content) values (?,?,?,?,?)");
            statement.setString(1, dto.getHeadline());
            statement.setString(2, dto.getSource());
            statement.setTimestamp(3, dto.getDate());
            statement.setString(4, dto.getCategory());
            statement.setString(5, dto.getContent());
            int row = statement.executeUpdate();
            return row;
        } catch (SQLException  | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public ResultSet getActiveNews(boolean active) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            System.out.println("connected");
            statement = connection.prepareStatement("select * from news_table where isActive = ?");
            statement.setBoolean(1,active);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getNewsById(int id) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("select * from news_table where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getNewsByIdAndDate(int id, Timestamp date) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("select * from news_table where id = ? AND date = ?" );
            statement.setInt(1,id);
            statement.setTimestamp(2,date);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getNewsByContextOrCategory(String content, String category) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("select * from news_table where content = ? OR category = ? ");
            statement.setString(1,content);
            statement.setString(2,category);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int updateNews(String headline,int id) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("update news_table set headline = ? where id = ?");
            connection.setAutoCommit(false);
            statement.setString(1, headline);
            statement.setInt(2, id);
            int row = statement.executeUpdate();
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


}
