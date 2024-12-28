package com.xworkz.jdbc.runner.dao;

import com.xworkz.jdbc.runner.dto.ThingsDto;

import java.sql.ResultSet;

public interface ThingsDao {
    int save(String title, String author, String genres);
//    int save(ThingsDto dto);// using Dto
    ResultSet getAllData();

}
