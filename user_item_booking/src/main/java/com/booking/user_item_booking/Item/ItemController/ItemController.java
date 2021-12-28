package com.booking.user_item_booking.Item.ItemController;

import java.util.LinkedList;
import java.util.Optional;

import com.booking.user_item_booking.Item.Entity.Item;
import com.booking.user_item_booking.Item.Entity.ItemRepository;
import com.booking.user_item_booking.Item.ItemService.ItemService;

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
    @Autowired
    private ItemService service;

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

    @PostMapping("/item")
    public Item addItem(@Validated @RequestBody Item item){
        item=this.service.addItem(item);
    Item i= this.repository.save(item);
        return i;
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable("id")int id){
        this.repository.deleteById(id);
        
    }
     
    @PutMapping("/item/{itemid}")
    public Item updatItem(@RequestBody Item item,@PathVariable("itemid") int itemid){
      
        this.service.updateItem( item, itemid);
        this.repository.save(item);
        return item;
      }
  
}
