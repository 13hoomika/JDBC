package com.xworkz.ecom.runner;

import com.xworkz.ecom.dao.ProductDao;
import com.xworkz.ecom.dao.ProductDaoImpl;

public class UpdateProducts {
    private static ProductDao productDao = new ProductDaoImpl();
    public static void main(String[] args) {
        //update
        int updatedRow = productDao.updateProductByName("VivoBook 16",15);
        System.out.println(updatedRow + " row updated");
    }
}
