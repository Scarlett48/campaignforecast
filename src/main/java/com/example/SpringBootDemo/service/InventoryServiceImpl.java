package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Item;
import com.example.SpringBootDemo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {


    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void addItem(Item item) {
        itemRepository.addItem(item);
    }

    @Override
    public Item searchItem(int id) {
        return itemRepository.searchItem(id);
    }

    @Override
    public Item searchItemByName(String name) {
        return itemRepository.searchItemByName(name);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.updateItem(item);
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteItem(id);
    }

    @Override
    public boolean doesItemExist(Item item) {
        return itemRepository.doesItemExist(item);
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAllItems();
    }
}
