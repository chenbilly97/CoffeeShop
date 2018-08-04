package com.spring.coffeeshop.service;

import com.spring.coffeeshop.model.Item;
import com.spring.coffeeshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    ItemRepository itemRepository;

    public ResponseEntity getAllItems(String type)
    {
        try {
            return ResponseEntity.accepted().body(itemRepository.findAllByType(type));
        } catch (Exception e)
        {
            System.out.println(e);
            return ResponseEntity.badRequest().body("");
        }
    }


    public ResponseEntity addItem(String name,String description,String type,float price)
    {
        Item exist = itemRepository.findByName(name);
        Item item;
        if (exist == null)
        {
            item = new Item(name,description,type,price);
            itemRepository.save(item);
            return ResponseEntity.ok().body("");
        }
        else
            return ResponseEntity.badRequest().body("");
    }

    public ResponseEntity deleteItem(String name)
    {
        Item exist = itemRepository.findByName(name);
        if (exist != null)
        {
            itemRepository.delete(exist);
            return ResponseEntity.ok().body("");
        }
        else
            return ResponseEntity.badRequest().body("");
    }

    public ResponseEntity updateItem(String name,String newName,String description,String type,float price)
    {
        Item exist = itemRepository.findByName(name);
        if (exist != null)
        {
            exist.setName(newName);
            exist.setDescription(description);
            exist.setType(type);
            exist.setPrice(price);
            itemRepository.save(exist);
            return ResponseEntity.ok().body("");
        }
        else
            return ResponseEntity.badRequest().body("");
    }
}
