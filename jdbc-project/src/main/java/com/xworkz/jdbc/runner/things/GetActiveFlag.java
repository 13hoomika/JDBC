package com.xworkz.jdbc.runner.things;

import com.xworkz.jdbc.dao.ThingsDao;
import com.xworkz.jdbc.dao.ThingsDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetActiveFlag {
    private static ThingsDao thingsDao = new ThingsDaoImpl();
    public static void main(String[] args) {
        ResultSet resultSet = thingsDao.getActiveThings(true);
        boolean isEmpty = true; // instead of if condition
        try{
            while (resultSet.next()){
                isEmpty = false;
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                String genres = resultSet.getString(4);
                System.out.println("Id: "+ id + " Title: " + title + " Author: " + author + " Genres: "+ genres);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if(isEmpty)

                System.out.println("No Data Found");
        }
    }
}
