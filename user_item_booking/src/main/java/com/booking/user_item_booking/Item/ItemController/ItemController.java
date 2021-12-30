package com.booking.user_item_booking.Item.ItemController;

import java.util.LinkedList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.booking.user_item_booking.Item.Entity.Item;
import com.booking.user_item_booking.Item.Entity.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ItemController {
    @Autowired
    private ItemRepository repository;
   
    @GetMapping("/item")
    public ResponseEntity<LinkedList<Item>> getAllItem(){
            LinkedList<Item> list= repository.getAllItem();
            if(list.size()<=0){
            System.out.println("error please add data in Table item");
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
              return  ResponseEntity.of(Optional.of(list));
        }
    }
     @Transactional
    @PostMapping("/item")
    public Item addItem(@Validated @RequestBody Item item){
        this.repository.addItem(item.getId(),item.getName(),item.getUid());
   
        return item;
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable("id")int id){
        this.repository.deleteById(id);
        
    }
     @Transactional
    @PutMapping("/item/{itemid}")
    public Item updatItem(@RequestBody Item item,@PathVariable("itemid") int itemid){
      
        this.repository.updateItem(item.getId(),item.getName(),item.getUid(), itemid);
       
        return item;
      }
  
}
