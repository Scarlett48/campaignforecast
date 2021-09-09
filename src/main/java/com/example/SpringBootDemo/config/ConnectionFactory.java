package com.example.SpringBootDemo.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String url = "jdbc:postgresql://localhost:5432/test";
    private static final String user = "postgres";
    private static final String password = "Admin@123";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
