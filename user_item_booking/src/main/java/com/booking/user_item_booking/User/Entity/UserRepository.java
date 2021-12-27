package com.booking.user_item_booking.User.Entity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>{
    
    @Query(value = "select * from user",nativeQuery = true)
    public ArrayList<User> getAllUser();
}

