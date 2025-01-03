package com.xworkz.weather.runner;

import com.xworkz.weather.dao.WeatherDao;
import com.xworkz.weather.dao.WeatherDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetByCityAndId {
    private static WeatherDao dao = new WeatherDaoImpl();

    public static void main(String[] args) {
        System.out.println("\n=============  getBy City Or id ==============");
        boolean isEmpty1 = true;
        ResultSet resultSet2 = dao.getByCityAndId("Bengaluru",1);
        try {
            while (resultSet2.next()) {
                isEmpty1 = false;
                int id = resultSet2.getInt(1);
                String city = resultSet2.getString(2);
                int temperature = resultSet2.getInt(3);
                int humidity = resultSet2.getInt(4);
                System.out.println("Id: "+ id + " city: " + city + " temperature: " + temperature + " humidity: "+ humidity );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (isEmpty1){
                System.out.println("City not Found");
            }
        }
    }

}
