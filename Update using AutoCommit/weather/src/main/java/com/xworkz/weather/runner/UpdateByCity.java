package com.xworkz.weather.runner;

import com.xworkz.weather.dao.WeatherDao;
import com.xworkz.weather.dao.WeatherDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateByCity {
    private static WeatherDao dao = new WeatherDaoImpl();

    public static void main(String[] args) {
        System.out.println("\n========== updateByCity ============");
        int row1 = dao.updateByCity("Delhi",10,"Heavy Rain");
        System.out.println(row1 + " row affected");
    }
}
