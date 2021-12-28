
package com.booking.user_item_booking.User.UserController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import com.booking.user_item_booking.User.Entity.User;
import com.booking.user_item_booking.User.Entity.UserRepository;
import com.booking.user_item_booking.User.UserService.UserService;

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
    @Autowired
    private UserService service;
 
    @GetMapping("/user")
    public ArrayList<User> getAllUser(){
        ArrayList<User> user=repository.getAllUser();
        return user;
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@Validated @RequestBody User user){
    
    String s=this.service.addUser(user).getEmail();
    String m=null;
     ArrayList<User> list=repository.getAllUser();
    try{
        Iterator itr=list.iterator();
        while(itr.hasNext()){  
            User st=(User)itr.next();
            if(st.getEmail().equals(s)) {
                 m=st.getEmail();
            }else{
               continue;
                
            }
        }
        
 if(m.equals(s)){
   
   return ResponseEntity.badRequest().body("Email is already taken");
 // return ResponseEntity.ok().body("Email is already taken");
 }else{
    user=this.service.addUser(user);
    User u= this.repository.save(user);
    return ResponseEntity.of(Optional.of(u));
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

    @PutMapping("/user/{userid}")
    public User updatUser(@RequestBody User user,@PathVariable("userid") int userid){
      
        this.service.updateUser( user,userid);
        this.repository.save(user);
        return user;
      }
}
