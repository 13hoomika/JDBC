package com.xworkz.weather.runner;

import com.xworkz.weather.dao.WeatherDao;
import com.xworkz.weather.dao.WeatherDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetById {
    private static WeatherDao dao = new WeatherDaoImpl();

    public static void main(String[] args) {
        System.out.println("\n=============  getById ==============");
        boolean isEmptyTable = true;
        ResultSet resultSet1 = dao.getById(2);
        try {
            while (resultSet1.next()) {
                isEmptyTable = false;
                int id = resultSet1.getInt(1);
                String city = resultSet1.getString(2);
                int temperature = resultSet1.getInt(3);
                int humidity = resultSet1.getInt(4);
                String weatherCondition = resultSet1.getString(5);
                String sunriseTime = resultSet1.getString(6);
                String sunsetTime = resultSet1.getString(7);
                System.out.println("Id: "+ id + " city: " + city + " temperature: " + temperature + " humidity: "+ humidity +
                        " weatherCondition: " + weatherCondition + " sunriseTime: " + sunriseTime + " sunsetTime: " + sunsetTime);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (isEmptyTable){
                System.out.println("Id not Found");
            }
        }
    }
}
