package com.xworkz.ecom.runner;

import com.xworkz.ecom.dao.ProductDao;
import com.xworkz.ecom.dao.ProductDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetProductByIdOrName {
    public static ProductDao productDao = new ProductDaoImpl();
    public static void main(String[] args) {
        System.out.println("============= product info by id or name =============");
        ResultSet resultSet1 = productDao.getProductByIdOrName(4,"VivoBook 16");
        boolean isEmpty1 = true;
        try {
            while (resultSet1.next()){
                isEmpty1 = false;
                int id = resultSet1.getInt(1);
                String name = resultSet1.getString(2);
                String brand = resultSet1.getString(3);
                double price = resultSet1.getDouble(4);
                int quantity = resultSet1.getInt(5);
                String category = resultSet1.getString(6);

                System.out.println("Product Id: " + id + ", name: " + name +
                        ", brand: " + brand + ", price: " + price +
                        ", quantity: " + quantity + ", category: "+ category);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmpty1) System.out.println("id not found!!");
        }
    }
}
