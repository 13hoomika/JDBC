package com.xworkz.weather.runner;

import com.xworkz.weather.dao.Dao;
import com.xworkz.weather.dao.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class GetNewsByContextOrCategory {
    static Dao dao = new DaoImpl();

    public static void main(String[] args) {
        System.out.println("\n=============  getNewsByContextOrCategory ==============");
        boolean isEmpty = true;
        ResultSet resultSet3 = dao.getNewsByContextOrCategory("Polls show a close race in the US elections.","Culture");
        try {
            while (resultSet3.next()) {
                isEmpty = false;
                int id = resultSet3.getInt(1);
                String headline = resultSet3.getString(2);
                String source = resultSet3.getString(3);
                Timestamp Date = resultSet3.getTimestamp(4);
                String Category = resultSet3.getString(5);
                String Content = resultSet3.getString(6);
                System.out.println("Id: "+ id + " headline: " + headline + " source: " + source + " Date: "+ Date +
                        " Category: " + Category + " Content: " + Content);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (isEmpty){
                System.out.println("City and SunriseTime  not Found");
            }
        }
    }
}
