package com.xworkz.weather.runner;

import com.xworkz.weather.dao.WeatherDao;
import com.xworkz.weather.dao.WeatherDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteByCity {
    private static WeatherDao dao = new WeatherDaoImpl();

    public static void main(String[] args) {
        System.out.println("\n=============  delete data ==============");
        int row = dao.onDelete("Chennai");
        System.out.println(row + " row deleted");
    }
}
