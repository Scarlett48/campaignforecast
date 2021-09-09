// UseCase:
// Develop  Microservices for our online retails shop use-case.
// Create controller methods for adding new Product, search product by name,
// update product prices and delete a product from inventory.
// For now use service layer collection for inventory datastore.

// UseCase(online retail shop):
// Complete your online retail shop microservices to use Repository pattern and work with database to save,
// fetch and update product database. You can create a table product and use this for your microservices.

package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Item;
import com.example.SpringBootDemo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> listAllItems(){
        List<Item> items = inventoryService.findAllItems();
        if(items.isEmpty()){
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") int id){
        Item item = inventoryService.searchItem(id);

        if (item == null){
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PostMapping("/addItem")
    public  ResponseEntity<Item> addItem(@RequestBody Item item){
        if (inventoryService.doesItemExist(item)){
            return new ResponseEntity<Item>(HttpStatus.CONFLICT);
        }
        inventoryService.addItem(item);
        return new ResponseEntity<Item>(HttpStatus.CREATED);
    }

    @PutMapping("/updatePrice/{id}/{newPrice}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") int id, @PathVariable("newPrice")int newPrice){
        Item item = inventoryService.searchItem(id);

        if (item == null){
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        item.setItemPrice(newPrice);
        inventoryService.updateItem(item);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") int id){
        Item item = inventoryService.searchItem(id);

        if (item == null){
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        inventoryService.deleteItem(id);
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }


}
