package com.xworkz.weather.runner;

import com.xworkz.weather.dao.Dao;
import com.xworkz.weather.dao.DaoImpl;
import com.xworkz.weather.dto.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsertNews {
    private static Dao dao = new DaoImpl();
    public static void main(String[] args) {
        Dto dto = new Dto();
        dto.setId(0);
        dto.setHeadline("US Election Polls Tight");
        dto.setSource("NY Times");
        dto.setDate(Timestamp.valueOf("2024-12-31 18:00:00"));
        dto.setCategory("Politics");
        dto.setContent("Polls show a close race in the US elections.");
        int row = dao.insertNews(dto);
        System.out.println(row +" rows affected");


    }
}
