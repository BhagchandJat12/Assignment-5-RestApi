package com.booking.user_item_booking.Item.Entity;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Integer>{
    
    @Query(value = "select * from Item ",nativeQuery = true)
    public LinkedList<Item> getAllItem();

    
    
}
