package com.xworkz.jdbc.runner.library;
import java.sql.*;

public class AggregateFunctions {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library_sys";
            String username = "root";
            String password = "bhoomika#7";

            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();

            String avg = "SELECT AVG(no_of_books) AS avg_books FROM library";
            ResultSet resultSet1 = statement.executeQuery(avg);
            resultSet1.next();
            System.out.println("Average number of books in library table: " + resultSet1.getInt(1));

            String count = "SELECT COUNT(*) AS total_count FROM library GROUP BY ownership";
            ResultSet resultSet2 = statement.executeQuery(count);
            resultSet2.next();
            System.out.println("total count of ownership in library: " + resultSet2.getString(1));

//            String count1 = "SELECT ownership, COUNT(*) AS total_count FROM library GROUP BY ownership";
//            ResultSet resultSet3 = statement.executeQuery(count1);
//            while (resultSet3.next()) {
//                String ownership = resultSet3.getString("ownership");
//                int totalCount = resultSet3.getInt("total_count");
//                System.out.println("Ownership: " + ownership + ", Total Count: " + totalCount);
//            }


            String sum = "SELECT SUM(no_of_books) AS total_books FROM library";
            ResultSet resultSetSum = statement.executeQuery(sum);
            resultSetSum.next();
            int totalBooks = resultSetSum.getInt(1);
            System.out.println("Total Books: " + totalBooks);

            String min = "SELECT MIN(no_of_books) AS min_books FROM library";
            ResultSet resultSetMin = statement.executeQuery(min);
            resultSetMin.next();
            int minBooks = resultSetMin.getInt(1);
            System.out.println("Min Books: " + minBooks);

            String max = "SELECT MAX(no_of_books) AS max_books FROM library";
            ResultSet resultSetMax = statement.executeQuery(max);
            resultSetMax.next();
            int maxBooks = resultSetMax.getInt("max_books");
            System.out.println("Max Books: " + maxBooks);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if(statement!=null){
                    statement.close();;
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }

        }

    }
}
