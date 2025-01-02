package com.xworkz.weather.runner;

import com.xworkz.weather.dao.WeatherDao;
import com.xworkz.weather.dao.WeatherDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetByConditionOrSunrise {
    private static WeatherDao dao = new WeatherDaoImpl();
    public static void main(String[] args) {
        System.out.println("\n=============  getBy weatherCondition Or sunriseTime ==============");
        boolean isEmpty = true;
        ResultSet resultSet3 = dao.getByConditionOrSunrise("Heavy Rain","6:15 AM");
        try {
            while (resultSet3.next()) {
                isEmpty = false;
                int id = resultSet3.getInt(1);
                String city = resultSet3.getString(2);
                int temperature = resultSet3.getInt(3);
                int humidity = resultSet3.getInt(4);
                String weatherCondition = resultSet3.getString(5);
                String sunriseTime = resultSet3.getString(6);
                String sunsetTime = resultSet3.getString(7);
                System.out.println("Id: "+ id + " city: " + city + " temperature: " + temperature + " humidity: "+ humidity +
                        " weatherCondition: " + weatherCondition + " sunriseTime: " + sunriseTime + " sunsetTime: " + sunsetTime);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (isEmpty){
                System.out.println("City and SunriseTime  not Found");
            }
        }
    }
}
