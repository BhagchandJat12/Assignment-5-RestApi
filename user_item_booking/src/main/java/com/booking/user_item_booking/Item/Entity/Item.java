package com.booking.user_item_booking.Item.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String Name;

    @NonNull
    private int Uid;

    public Item() {
    }

    public Item(int id, String name, int uid) {
        this.id = id;
        Name = name;
        Uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    @Override
    public String toString() {
        return "Item [ id=" + id + ",Name=" + Name + ", Uid=" + Uid + "]";
    }

    
}
