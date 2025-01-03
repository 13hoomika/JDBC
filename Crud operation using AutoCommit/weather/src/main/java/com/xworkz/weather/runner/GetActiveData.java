package com.xworkz.weather.runner;

import com.xworkz.weather.dao.WeatherDao;
import com.xworkz.weather.dao.WeatherDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetActiveData {
    private static WeatherDao dao = new WeatherDaoImpl();

    public static void main(String[] args) {
        System.out.println("\n=============  active data ==============");
        ResultSet resultSet = dao.getActiveData(true);
        boolean isEmpty = true;
        try{
            while (resultSet.next()){
                isEmpty = false;
                int id = resultSet.getInt(1);
                String city = resultSet.getString(2);
                int temperature = resultSet.getInt(3);
                int humidity = resultSet.getInt(4);
                String weatherCondition = resultSet.getString(5);
                String sunriseTime = resultSet.getString(6);
                String sunsetTime = resultSet.getString(7);
                System.out.println("Id: "+ id + " city: " + city + " temperature: " + temperature + " humidity: "+ humidity +
                        " weatherCondition: " + weatherCondition + " sunriseTime: " + sunriseTime + " sunsetTime: " + sunsetTime);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if(isEmpty){
                System.out.println("Data not Found");
            }
        }
    }
}
