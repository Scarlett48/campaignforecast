package com.example.SpringBootDemo.repository;

import com.example.SpringBootDemo.config.NativeJDBC;
import com.example.SpringBootDemo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    @Autowired
    private NativeJDBC nativeJDBC;

    public boolean addItem(Item item){
        try {
            nativeJDBC.insertItem(item);
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Item searchItem(int id) {
        Item item = null;
        try {
            item = nativeJDBC.getItem(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public Item searchItemByName(String name) {
        return null;
    }

    @Override
    public void updateItem(Item item) {
        try {
            nativeJDBC.updateItem(item);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int id) {
        try {
            nativeJDBC.deleteItem(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean doesItemExist(Item item) {
        return searchItem(item.getItemID()) != null;
    }

    @Override
    public List<Item> findAllItems() {
        List<Item> items = nativeJDBC.getAllItems();
        return items;
    }

}
