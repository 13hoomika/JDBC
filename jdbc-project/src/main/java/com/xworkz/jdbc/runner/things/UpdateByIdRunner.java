package com.xworkz.jdbc.runner.things;

import com.xworkz.jdbc.dao.ThingsDao;
import com.xworkz.jdbc.dao.ThingsDaoImpl;

public class UpdateByIdRunner {
    static ThingsDao thingsDao = new ThingsDaoImpl();
    public static void main(String[] args) {
        int row = thingsDao.updateById("Joyful","Emily",2);
        System.out.println(row + " row affected");
    }
}
