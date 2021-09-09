package com.example.SpringBootDemo.config;

import com.example.SpringBootDemo.constants.SQLQuery;
import com.example.SpringBootDemo.model.Item;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NativeJDBC {

    public void create(String sql){
        System.out.println(sql);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement statement = conn.createStatement();) {

            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Item getItem(int id){
        ConnectionFactory connectionPG = new ConnectionFactory();
        Connection connection = connectionPG.getConnection();


        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLQuery.GET_ITEM + id);

            if(resultSet.next()){
                Item item = new Item(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4));

                return item;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<Item> getAllItems(){
        ConnectionFactory connectionPG = new ConnectionFactory();
        Connection connection = connectionPG.getConnection();

        List<Item> items = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLQuery.GET_ALL_ITEMS);

            while (resultSet.next()){
                Item item = new Item(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4));
                items.add(item);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public void insertItem(Item item){

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQLQuery.INSERT_ITEM);) {
            ps.setInt(1, item.getItemID());
            ps.setString(2, item.getItemName());
            ps.setInt(3, item.getItemPrice());
            ps.setInt(4, item.getItemQuantity());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Item item){
        ConnectionFactory connectionPG = new ConnectionFactory();
        Connection connection = connectionPG.getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement(SQLQuery.UPDATE_ITEM);

            ps.setString(1,item.getItemName());
            ps.setInt(2, item.getItemPrice());
            ps.setInt(3, item.getItemQuantity());
            ps.setInt(4, item.getItemID());

            ps.executeUpdate();

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteItem(int id){
        ConnectionFactory connectionPG = new ConnectionFactory();
        Connection connection = connectionPG.getConnection();

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLQuery.DELETE_ITEM + id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
