package com.xworkz.weather.dao;

import com.xworkz.weather.dto.Dto;

import java.sql.ResultSet;
import java.sql.Timestamp;

public interface Dao {
    int insertNews(Dto dto);
    ResultSet getActiveNews(boolean active);
    ResultSet getNewsById(int id);
    ResultSet getNewsByIdAndDate(int id, Timestamp date);
    ResultSet getNewsByContextOrCategory(String context, String category);
    int updateNews(String headline,int id);
}
