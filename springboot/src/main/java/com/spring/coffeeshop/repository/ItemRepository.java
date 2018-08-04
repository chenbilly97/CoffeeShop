package com.spring.coffeeshop.repository;

import com.spring.coffeeshop.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item,String> {
    Item findByName(String name);
    List<Item> findAllByType(String type);
}
