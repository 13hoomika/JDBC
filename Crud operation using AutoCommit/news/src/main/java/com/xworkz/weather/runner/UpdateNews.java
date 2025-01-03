package com.xworkz.weather.runner;

import com.xworkz.weather.dao.Dao;
import com.xworkz.weather.dao.DaoImpl;

public class UpdateNews {
    static Dao dao = new DaoImpl();

    public static void main(String[] args) {
        System.out.println("\n========== updateNewsById ============");
        int rows = dao.updateNews("Rising Stock Market ",2);
        System.out.println(rows + " row affected");
    }
}
