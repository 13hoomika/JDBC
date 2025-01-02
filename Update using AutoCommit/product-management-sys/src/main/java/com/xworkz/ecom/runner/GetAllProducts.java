package com.xworkz.ecom.runner;

import com.xworkz.ecom.dao.ProductDao;
import com.xworkz.ecom.dao.ProductDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllProducts {
    private static ProductDao productDao = new ProductDaoImpl();

    public static void main(String[] args) {
        System.out.println("============= all product details =============");
        ResultSet resultSet = productDao.getAllProducts();
        boolean isEmpty = true;
        try {
            while (resultSet.next()){
                isEmpty = false;
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String brand = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                int quantity = resultSet.getInt(5);
                String category = resultSet.getString(6);

                System.out.println("Product Id: " + id + ", name: " + name +
                        ", brand: " + brand + ", price: " + price +
                        ", quantity: " + quantity + ", category: "+ category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if(isEmpty) System.out.println("No data found");
        }

    }
}
