package com.xworkz.weather.runner;

import com.xworkz.weather.dao.Dao;
import com.xworkz.weather.dao.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class GetActiveNews {
    static Dao dao = new DaoImpl();

    public static void main(String[] args) {
        System.out.println("\n=============  getNewsById ==============");
        boolean isEmptyTable = true;
        ResultSet resultSet1 = dao.getNewsById(2);
        try {
            while (resultSet1.next()) {
                isEmptyTable = false;
                int id = resultSet1.getInt(1);
                String headline = resultSet1.getString(2);
                String source = resultSet1.getString(3);
                Timestamp Date = resultSet1.getTimestamp(4);
                String Category = resultSet1.getString(5);
                String Content = resultSet1.getString(6);
                System.out.println("Id: "+ id + " headline: " + headline + " source: " + source + " Date: "+ Date +
                        " Category: " + Category + " Content: " + Content);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (isEmptyTable){
                System.out.println("Id not Found");
            }
        }

        System.out.println("\n=============  Active data ==============");
        ResultSet resultSet = dao.getActiveNews(true);
        boolean isEmpty = true;
        try{
            while (resultSet.next()){
                isEmpty = false;
                int id = resultSet.getInt(1);
                String headline = resultSet.getString(2);
                String source = resultSet.getString(3);
                Timestamp Date = resultSet.getTimestamp(4);
                String Category = resultSet.getString(5);
                String Content = resultSet.getString(6);
                System.out.println("Id: "+ id + " headline: " + headline + " source: " + source + " Date: "+ Date +
                        " Category: " + Category + " Content: " + Content);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if(isEmpty){
                System.out.println("Data not Found");
            }
        }
    }
}
