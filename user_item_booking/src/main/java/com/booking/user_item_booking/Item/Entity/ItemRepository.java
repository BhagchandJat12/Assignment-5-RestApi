package com.booking.user_item_booking.Item.Entity;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,Integer>{
    
    @Query(value = "select * from Item ",nativeQuery = true)
    public LinkedList<Item> getAllItem();
     
    @Modifying
    @Query(value="update Item b set   b.id= :i , b.Name= :s , b.Uid= :e  where b.id= :u", nativeQuery = true)
    public void updateItem(@Param("i") int id,@Param("s") String name,@Param("e") int uid,@Param("u") int Uid);
    
    @Modifying
    @Query(value = "insert into Item (id,Name,Uid) values(:i ,:s,:e)",nativeQuery = true)
    public void addItem(@Param("i") int id,@Param("s") String name,@Param("e") int uid);

    @Modifying
    @Query(value = "select * from item i where i.Name=:n  ",nativeQuery = true)
    public LinkedList<Item> getByName(@Param("n") String name);
    
    
}
