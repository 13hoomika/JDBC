package com.xworkz.ecom.runner;

import com.xworkz.ecom.dao.ProductDao;
import com.xworkz.ecom.dao.ProductDaoImpl;

public class DeleteById {
    static ProductDao productDao = new ProductDaoImpl();

    public static void main(String[] args) {
        int row = productDao.onDeleteById(3);
        System.out.println(row + " row deleted");
    }
}
