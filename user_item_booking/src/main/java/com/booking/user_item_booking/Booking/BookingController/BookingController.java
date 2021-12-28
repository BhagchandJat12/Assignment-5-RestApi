package com.booking.user_item_booking.Booking.BookingController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import com.booking.user_item_booking.Booking.BookingService.BookingService;
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
    @Autowired
    private BookingService service;

    @GetMapping("/booking")
    public ArrayList<Booking> getAllUser(){
      ArrayList<Booking>  booking= repository.getAllBooking();
        return booking;
    }

    @PostMapping("/booking")
    public ResponseEntity<?> addBooking(@Validated @RequestBody Booking booking){
      try{
        LocalDate sDate=this.service.addBooking(booking).getStarttime();
        LocalDate m=null;
        ArrayList<Booking> list= repository.getAllBooking();
        Iterator itr=list.iterator();
        
        while(itr.hasNext()){  
            Booking st=(Booking)itr.next(); 
            LocalDate d=st.getStarttime();
            if(d.equals(sDate)) {
                m=d;
               
            }else{
                 continue;    
            } 
          } 
         
        if(m.equals(sDate)){
          System.out.println("Dates overlapes");
           return ResponseEntity.badRequest().body("Dates overlapes ");
        }else{
             booking=this.service.addBooking(booking);
        Booking b= this.repository.save(booking);
        return ResponseEntity.of(Optional.of(b));    
        
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

    @PutMapping("/booking/{bookingid}")
    public Booking updatEvent(@RequestBody Booking booking,@PathVariable("bookingid") int bookingid){
      
        this.service.updateBooking( booking, bookingid);
        this.repository.save(booking);
        return booking;
      }
}
