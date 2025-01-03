package com.xworkz.weather.dao;

import com.xworkz.weather.dto.WeatherDto;

import java.sql.ResultSet;

public interface WeatherDao {
    int insert(WeatherDto dto);
//    ResultSet getAllData();
    ResultSet getActiveData(boolean active);
    ResultSet getById(int id);
    ResultSet getByCityAndId(String city, int id);
    ResultSet getByConditionOrSunrise(String condition, String sunrise);
    int updateByCity(String city,int temp, String condition);
    int onDelete(String city);
}
