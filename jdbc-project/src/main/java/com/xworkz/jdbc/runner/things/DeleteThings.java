package com.xworkz.jdbc.runner.things;

import com.xworkz.jdbc.dao.ThingsDao;
import com.xworkz.jdbc.dao.ThingsDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteThings {
    private static ThingsDao thingsDao = new ThingsDaoImpl();
    public static void main(String[] args) {
        int id= 2;
        int row = thingsDao.onDeleteById(id);
        System.out.println(row+" row deleted");
    }
}
