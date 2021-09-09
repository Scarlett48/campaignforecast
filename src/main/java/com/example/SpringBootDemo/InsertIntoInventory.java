package com.example.SpringBootDemo;

import com.example.SpringBootDemo.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertIntoInventory {
    private static final String sql = "INSERT INTO INVENTORY " +
            "(id, name, price, quantity) VALUES (?, ?, ?, ?)";

    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);) {

            ps.setInt(1,101);
            ps.setString(2, "Pen");
            ps.setInt(3, 15);
            ps.setInt(4,200);

            ps.executeUpdate();

            ps.setInt(1,102);
            ps.setString(2, "Purse");
            ps.setInt(3, 1000);
            ps.setInt(4,20);

            ps.executeUpdate();

            ps.setInt(1,103);
            ps.setString(2, "Toothpaste");
            ps.setInt(3, 50);
            ps.setInt(4,80);

            ps.executeUpdate();

            ps.setInt(1,104);
            ps.setString(2, "Eyeliner");
            ps.setInt(3, 250);
            ps.setInt(4,50);

            ps.executeUpdate();

            ps.setInt(1,105);
            ps.setString(2, "Chips");
            ps.setInt(3, 30);
            ps.setInt(4,100);

            ps.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }}