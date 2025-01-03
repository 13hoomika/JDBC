package com.xworkz.weather.runner;

import com.xworkz.weather.dao.WeatherDao;
import com.xworkz.weather.dao.WeatherDaoImpl;
import com.xworkz.weather.dto.WeatherDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertRunner {
    private static WeatherDao dao = new WeatherDaoImpl();
    public static void main(String[] args) {
        WeatherDto dto = new WeatherDto();
        dto.setCity("Mysore");
        dto.setTemperature(25);
        dto.setHumidity(50);
        dto.setWeatherCondition("Cloudy");
        dto.setSunriseTime("6:35 AM");
        dto.setSunsetTime("6:15 PM");
        dto.setActive(true);
        int row = dao.insert(dto);
        System.out.println(row +" rows affected");

    }
}
