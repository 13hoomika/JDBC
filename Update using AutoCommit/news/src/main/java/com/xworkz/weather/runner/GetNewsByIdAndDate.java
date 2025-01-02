package com.xworkz.weather.runner;

import com.xworkz.weather.dao.Dao;
import com.xworkz.weather.dao.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class GetNewsByIdAndDate {
    static Dao dao = new DaoImpl();

    public static void main(String[] args) {
        System.out.println("\n=============  getNewsByIdAndDate ==============");
        boolean isEmpty = true;
        ResultSet resultSet2 = dao.getNewsByIdAndDate(1, Timestamp.valueOf("2024-12-31 20:00:00"));
        try {
            while (resultSet2.next()) {
                isEmpty = false;
                int id = resultSet2.getInt(1);
                String headline = resultSet2.getString(2);
                String source = resultSet2.getString(3);
                Timestamp Date = resultSet2.getTimestamp(4);
                String Category = resultSet2.getString(5);
                String Content = resultSet2.getString(6);
                System.out.println("Id: "+ id + " headline: " + headline + " source: " + source + " Date: "+ Date +
                        " Category: " + Category + " Content: " + Content);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (isEmpty){
                System.out.println("news not Found");
            }
        }
    }
}
