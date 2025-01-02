package com.xworkz.jdbc.dao;

import java.sql.ResultSet;

public interface ThingsDao {
    //    int save(ThingsDto dto);// using Dto
    int save(String title, String author, String genres);
    ResultSet getAllData();
    ResultSet getById(int id);
    ResultSet getActiveThings(boolean isActive);
    int updateById(String genres,String author,int id);
    int onDeleteById(int id);
}
