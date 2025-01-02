package com.xworkz.jdbc.runner.things;

import com.xworkz.jdbc.dao.ThingsDao;
import com.xworkz.jdbc.dao.ThingsDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThingsRunner{
    private static ThingsDao thingsDao = new ThingsDaoImpl();
    public static void main(String[] args) {
//        int row = thingsDao.save("It Ends With Us", "Colleen Hoover", "Romance Fiction");
        //System.out.println(row +" rows affected");

        ResultSet resultSet = thingsDao.getAllData();
        boolean isEmpty = true; // instead of if condition
        try{
//            boolean checkData = resultSet.isFirst();
//            if (!resultSet.isFirst()){ // false
                while (resultSet.next()){
                    isEmpty = false;
                    int id = resultSet.getInt("book_id");
                    String title = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    String genres = resultSet.getString(4);
                    System.out.println("Id: "+ id + " Title: " + title + " Author: " + author + " Genres: "+ genres);
                }
//            }else System.out.println("No Data Found");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }
}
