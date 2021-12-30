package com.booking.user_item_booking.Booking.BookingController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.booking.user_item_booking.Booking.Entity.Booking;
import com.booking.user_item_booking.Booking.Entity.BookingRepository;

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
public class BookingController {
    
    @Autowired
    private BookingRepository repository;

    @GetMapping("/booking")
    public ArrayList<Booking> getAllUser(){
      ArrayList<Booking>  booking= repository.getAllBooking();
        return booking;
    }
   @Transactional
    @PostMapping("/booking")
    public ResponseEntity<?> addBooking(@Validated @RequestBody Booking booking){
      try{
        LocalDate sDate=booking.getStarttime();
       LinkedList<Booking> list=this.repository.getByStarttime(sDate);
       
        if(list.size()!=0){
          System.out.println("Dates overlapes");
           return ResponseEntity.badRequest().body("Dates overlapes ");
        }else{
        
        this.repository.addBooking(booking.getId(),booking.getStarttime(),booking.getEndtime());
        return ResponseEntity.of(Optional.of(booking));    
        
        }
      }catch(Exception e){
         System.out.println("Dates overlapped"+ e.getMessage());
      }
      return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/booking/{id}")
    public void deleteBook(@PathVariable("id")int id){
        this.repository.deleteById(id);
        
    }
    @Transactional
    @PutMapping("/booking/{bookingid}")
    public Booking updatEvent(@RequestBody Booking booking,@PathVariable("bookingid") int bookingid){
        this.repository.updateBooking(booking.getUid(),booking.getId(),booking.getStarttime(),booking.getEndtime(), bookingid);
        return booking;
      }
}
