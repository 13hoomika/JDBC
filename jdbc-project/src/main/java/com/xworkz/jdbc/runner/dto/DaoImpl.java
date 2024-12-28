//package com.xworkz.jdbc.runner.dao;
//
//import com.xworkz.jdbc.runner.dto.ThingsDto;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class DaoImpl implements ThingsDao {
//    Connection connection = null;
//    PreparedStatement preparedStatement= null;
//
//    @Override
//    public int save(ThingsDto dto) {
//        String url = "jdbc:mysql://localhost:3306/library_sys";
//        String user = "root";
//        String pass = "bhoomika#7";
//        try {
//            connection = DriverManager.getConnection(url,user,pass);
//            preparedStatement = connection.prepareStatement("insert into things value(?,?,?,?)");
//            preparedStatement.setInt(1,0);
//            preparedStatement.setString(2, dto.getBookTitle());
//            preparedStatement.setString(3, dto.getBookAuthor());
//            preparedStatement.setString(4, dto.getBookGenres());
//            int row = preparedStatement.executeUpdate();
//            return row;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return 0;
//        }finally {
//            try {
//                if (connection != null){
//                    connection.close();
//                }
//                if (preparedStatement != null){
//                    preparedStatement.close();
//                }
//            }catch (SQLException e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//}
