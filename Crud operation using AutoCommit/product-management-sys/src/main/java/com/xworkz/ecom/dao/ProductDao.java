package com.xworkz.ecom.dao;

import java.sql.ResultSet;

public interface ProductDao {
    int insert(String name,String brand,double price,int quantity, String category,boolean isActive);
    ResultSet getAllProducts();
    ResultSet getActiveProducts(boolean isActive);
    ResultSet getProductByIdOrName(int id,String name);
    ResultSet getProductByCatAndPrice(String category, double price);
    int updateProductByName(String name, int quantity);
    int onDeleteById(int id);
}
