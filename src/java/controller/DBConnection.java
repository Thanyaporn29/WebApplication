package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Food;

public class DBConnection {

    public boolean insertNewFood(Food food) {
        boolean result = false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydrink",
                "root", "Thanyaporn_29"
            );

            Statement statement = connection.createStatement();
            
            String query = "INSERT INTO drink (name, levelSweet, size, price) "
                         + "VALUES ('" + food.getName() + "', '"
                         + food.getLevelSweet() + "', '"
                         + food.getSize() + "', "
                         + food.getPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query); // executeUpdate returns row count
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }

        return result;
    }

    public void testRetrieve() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydrink",
                "root", "Thanyaporn_29"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "SELECT name, levelSweet, size, price FROM drink"
            );

            while (resultSet.next()) {
                String name = resultSet.getString("name").trim();
                String levelSweet = resultSet.getString("levelSweet").trim();
                String size = resultSet.getString("size").trim();
                double price = resultSet.getDouble("price");

                System.out.println("Name: " + name + ", Level Sweet: " + levelSweet 
                    + ", Size: " + size + ", Price: " + price);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
    }
}
