package com.example.SpringBootDemo;

import com.example.SpringBootDemo.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;

public class CreateInventoryDatabase {

    private static final String sql = "CREATE TABLE INVENTORY " +
            "(id INTEGER NOT NULL," +
            "name VARCHAR(255)," +
            "price INTEGER," +
            "quantity INTEGER, " +
            "PRIMARY KEY (id))";

    public static void main(String[] args) {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
