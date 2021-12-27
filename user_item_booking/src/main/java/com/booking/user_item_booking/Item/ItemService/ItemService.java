package com.booking.user_item_booking.Item.ItemService;
import java.util.LinkedList;
import java.util.stream.Collectors;

import com.booking.user_item_booking.Item.Entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    private static LinkedList<Item> list= new LinkedList<>();
    public Item addItem(Item item) {
        list.add(item);
        return item;
    }

    public void updateItem(Item  item, int itemid) {
        list= (LinkedList<Item>) list.stream().map(b->{
       
            if(b.getId()==itemid){
                b.setUid(item.getUid());
                b.setName(item.getName());}
                return b;
            
        }).collect(Collectors.toList());
        
    }
    
}
