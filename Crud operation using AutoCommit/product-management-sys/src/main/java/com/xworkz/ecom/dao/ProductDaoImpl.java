package com.xworkz.ecom.dao;

import java.sql.*;

public class ProductDaoImpl implements ProductDao{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    private final String URL = "jdbc:mysql://localhost:3306/country";
    private final String USER = "root";
    private final String PASS = "bhoomika#7";

    @Override
    public int insert(String name, String brand, double price, int quantity, String category,boolean isActive) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("MySQL connected");
            preparedStatement = connection.prepareStatement("insert product_info value (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,brand);
            preparedStatement.setDouble(4,price);
            preparedStatement.setInt(5,quantity);
            preparedStatement.setString(6,category);
            preparedStatement.setBoolean(7,isActive);
            int row = preparedStatement.executeUpdate();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public ResultSet getAllProducts() {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            preparedStatement = connection.prepareStatement("select * from product_info");
            ResultSet resultSet = preparedStatement.executeQuery();
            return  resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getActiveProducts(boolean isActive) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            preparedStatement = connection.prepareStatement("select * from product_info where isActive = ?");
            preparedStatement.setBoolean(1,isActive);
            ResultSet resultSet = preparedStatement.executeQuery();
            return  resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getProductByCatAndPrice(String category,double price) {
        try {
            connection  = DriverManager.getConnection(URL,USER,PASS);
            preparedStatement = connection.prepareStatement("select * from product_info where category = ? and price = ?");
            preparedStatement.setString(1,category);
            preparedStatement.setDouble(2,price);
            ResultSet resultSet = preparedStatement.executeQuery();
            return  resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getProductByIdOrName(int id,String name) {
        try {
            connection  = DriverManager.getConnection(URL,USER,PASS);
            preparedStatement = connection.prepareStatement("select * from product_info where id = ? or p_name = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return  resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int updateProductByName(String name, int quantity) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("update product_info set quantity = ? where p_name = ?");
            preparedStatement.setInt(1,quantity);
            preparedStatement.setString(2,name);
            int row = preparedStatement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            }catch (SQLException ex){
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public int onDeleteById(int id) {
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("delete from product_info where id = ? ");
            preparedStatement.setInt(1,id);
            int row = preparedStatement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return 0;
    }
}
