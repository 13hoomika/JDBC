package com.xworkz.ecom.runner;

import com.xworkz.ecom.dao.ProductDao;
import com.xworkz.ecom.dao.ProductDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetProductsByCatAndPrice {
    private  static ProductDao productDao = new ProductDaoImpl();

    public static void main(String[] args) {
        System.out.println("============= product info by category and price =============");
        ResultSet resultSet2 = productDao.getProductByCatAndPrice("Electronics",43000.0);
        boolean isEmpty = true;
        try {
            while (resultSet2.next()){
                isEmpty = false;
                int id = resultSet2.getInt(1);
                String name = resultSet2.getString(2);
                String brand = resultSet2.getString(3);
                double price = resultSet2.getDouble(4);
                int quantity = resultSet2.getInt(5);
                String category = resultSet2.getString(6);

                System.out.println("Product Id: " + id + ", name: " + name +
                        ", brand: " + brand + ", price: " + price +
                        ", quantity: " + quantity + ", category: "+ category);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmpty) System.out.println("product with given category and price not found!!");
        }
    }
}
