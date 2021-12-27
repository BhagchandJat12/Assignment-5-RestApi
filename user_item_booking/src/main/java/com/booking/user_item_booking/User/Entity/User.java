package com.booking.user_item_booking.User.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "User")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Uid;

    @NonNull
    private String Name;

    @NonNull
    @Column(unique = true)
    private String Email;

    public User() {
    }

    public User(int uid, String name, String email) {
        Uid = uid;
        Name = name;
        Email = email;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User [Uid=" + Uid + ", Name=" + Name + ", Email=" + Email + "]";
    }
    
}
