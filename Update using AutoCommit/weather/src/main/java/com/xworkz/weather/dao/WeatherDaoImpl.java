package com.xworkz.weather.dao;

import com.xworkz.weather.dto.WeatherDto;

import java.sql.*;

public class WeatherDaoImpl implements WeatherDao {
    Connection connection = null;
    PreparedStatement statement= null;

    final String URL = "jdbc:mysql://localhost:3306/country";
    final String USER = "root";
    final String PASS = "bhoomika#7";

    @Override
    public int insert(WeatherDto dto) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("insert into weather_table (city, temperature, humidity, weather_condition, sunrise_time, sunset_time,isActive) values (?,?,?,?,?,?,?)");
            statement.setString(1, dto.getCity());
            statement.setInt(2, dto.getTemperature());
            statement.setInt(3, dto.getHumidity());
            statement.setString(4, dto.getWeatherCondition());
            statement.setString(5, dto.getSunriseTime());
            statement.setString(6, dto.getSunsetTime());
            statement.setBoolean(7, dto.isActive());
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
    public ResultSet getActiveData(boolean active) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("select * from weather_table where isActive =?");
            statement.setBoolean(1,active);
            ResultSet resultSet = statement.executeQuery();
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
            statement = connection.prepareStatement("select * from weather_table where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByCityAndId(String city, int id) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("select * from weather_table where city = ? AND id = ?" );
            statement.setString(1,city);
            statement.setInt(2,id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByConditionOrSunrise(String condition, String sunrise) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("select * from weather_table where weather_condition = ? OR sunrise_time = ? ");
            statement.setString(1,condition);
            statement.setString(2,sunrise);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int updateByCity(String city,int temp, String condition) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            statement = connection.prepareStatement("update weather_table set temperature = ?, weather_condition = ? where city = ?");
            connection.setAutoCommit(false);
            statement.setInt(1, temp);             // Set temperature as first parameter
            statement.setString(2, condition);     // Set weather condition as second parameter
            statement.setString(3, city);
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

    @Override
    public int onDelete(String city) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("delete from weather_table where city = ? ");
            statement.setString(1,city);
            int row = statement.executeUpdate();
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
