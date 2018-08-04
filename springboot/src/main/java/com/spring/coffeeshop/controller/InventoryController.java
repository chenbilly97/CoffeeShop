package com.spring.coffeeshop.controller;


import com.spring.coffeeshop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @CrossOrigin
    @GetMapping("/all/{type}")
    public ResponseEntity getCoffeeList(@PathVariable String type)
    {
        return  inventoryService.getAllItems(type);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity addItem(@RequestParam String name,@RequestParam String description,@RequestParam float price,@RequestParam String type)
    {
        return inventoryService.addItem(name,description,type,price);
    }

    @CrossOrigin
    @PostMapping("/delete")
    public ResponseEntity deleteItem(@RequestParam String name)
    {
        return inventoryService.deleteItem(name);
    }

    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity updateItem(@RequestParam String name,@RequestParam String newName,@RequestParam String description,@RequestParam String type,@RequestParam float price )
    {
        return inventoryService.updateItem(name,newName,description,type,price);
    }

}
