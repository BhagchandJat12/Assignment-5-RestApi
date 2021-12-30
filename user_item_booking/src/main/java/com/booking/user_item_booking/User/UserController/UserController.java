
package com.booking.user_item_booking.User.UserController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.booking.user_item_booking.User.Entity.User;
import com.booking.user_item_booking.User.Entity.UserRepository;

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
public class UserController {
    
    @Autowired
    private UserRepository repository;
 
    @GetMapping("/user")
    public ArrayList<User> getAllUser(){
        ArrayList<User> user=repository.getAllUser();
        return user;
    }
     @Transactional
    @PostMapping("/user")
    public ResponseEntity<?> addUser(@Validated @RequestBody User user){
 try{
    String s=user.getEmail();
     LinkedList<User> list=repository.getByEmail(s);
   
    if(list.size()!=0){
   
   return ResponseEntity.badRequest().body("Email is already taken");
 
 }else{
    this.repository.addUser(user.getUid(),user.getName(),user.getEmail());
    
    return ResponseEntity.of(Optional.of(user));
    }
 
 }catch(Exception e){
     System.out.println("Email is already taken  "+ e.getMessage()); 
 }
 return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id")int id){
        this.repository.deleteById(id);
        
    }
    @Transactional
    @PutMapping("/user/{userid}")
    public User updatUser(@RequestBody User user,@PathVariable("userid") int userid){
      
        this.repository.updateUser(user.getUid(),user.getName(),user.getEmail(),userid);
       
        return user;
      }
}
