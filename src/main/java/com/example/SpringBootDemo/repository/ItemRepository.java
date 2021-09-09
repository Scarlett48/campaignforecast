package com.example.SpringBootDemo.repository;

import com.example.SpringBootDemo.model.Item;

import java.util.List;

public interface ItemRepository {
    boolean addItem(Item item);

    Item searchItem(int id);

    Item searchItemByName(String name);

    void updateItem(Item item);

    void deleteItem(int id);

    boolean doesItemExist(Item item);

    List<Item> findAllItems();


}
