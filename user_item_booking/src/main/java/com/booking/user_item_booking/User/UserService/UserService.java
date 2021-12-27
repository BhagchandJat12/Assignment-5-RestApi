package com.booking.user_item_booking.User.UserService;

import java.util.LinkedList;

import java.util.stream.Collectors;

import com.booking.user_item_booking.User.Entity.User;

import org.springframework.stereotype.Component;


@Component
public class UserService {
    
    private static LinkedList<User> list= new LinkedList<>();
    public User addUser(User user) {
        list.add(user);
        return user;
    }
    public void updateUser(User user, int userid) {
        list= (LinkedList<User>) list.stream().map(b->{
       
            if(b.getUid()==userid){
                b.setUid(user.getUid());
                b.setName(user.getName());
            b.setEmail(user.getEmail());}
                return b;
            
        }).collect(Collectors.toList());
        
    }
   
    }
    

