package com.xworkz.jdbc.runner;

import com.xworkz.jdbc.runner.dao.ThingsDao;
import com.xworkz.jdbc.runner.dao.ThingsDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThingsRunner{
    private static ThingsDao thingsDao = new ThingsDaoImpl();
    public static void main(String[] args) {
//        int row = thingsDao.save("It Ends With Us", "Colleen Hoover", "Romance Fiction");
        //System.out.println(row +" rows affected");

        ResultSet resultSet = thingsDao.getAllData();
        try{
            boolean checkData = resultSet.isFirst();
            if (!checkData){
                while (resultSet.next()){
                    int id = resultSet.getInt("book_id");
                    String title = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    String genres = resultSet.getString(4);
                    System.out.println("Id: "+ id + " Title: " + title + " Author: " + author + " Genres: "+ genres);
                }
            }else System.out.println("No Data Found");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
