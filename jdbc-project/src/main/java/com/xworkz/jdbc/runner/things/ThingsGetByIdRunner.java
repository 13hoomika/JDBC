package com.xworkz.jdbc.runner.things;

import com.xworkz.jdbc.dao.ThingsDao;
import com.xworkz.jdbc.dao.ThingsDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThingsGetByIdRunner {
    private static ThingsDao thingsDao = new ThingsDaoImpl();
    public static void main(String[] args) {
        boolean isEmpty = true;
        ResultSet resultSet = thingsDao.getById(2);
        try {
            while (resultSet.next()) {
                isEmpty = false;
                int id = resultSet.getInt(1);
                String author = resultSet.getString(2);
                String genres = resultSet.getString(3);
                System.out.println("Id: " + id + " Author: " + author + " Genres: " + genres);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            if (isEmpty){
//                System.out.println("No Data Found");
//            }
        }
    }
}
