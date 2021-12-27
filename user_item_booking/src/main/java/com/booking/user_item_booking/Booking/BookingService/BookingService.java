package com.booking.user_item_booking.Booking.BookingService;

import java.util.LinkedList;
import java.util.stream.Collectors;

import com.booking.user_item_booking.Booking.Entity.Booking;

import org.springframework.stereotype.Component;
@Component
public class BookingService {
    private static LinkedList<Booking> list= new LinkedList<>();
    public Booking addBooking(Booking booking) {
        list.add(booking);
        return booking;
    }
    
    public void updateBooking(Booking booking, int bookingid) {
        list= (LinkedList<Booking>) list.stream().map(b->{
       
            if(b.getId()==bookingid){
                b.setUid(booking.getUid());
                b.setStarttime(booking.getStarttime());
                b.setEndtime(booking.getEndtime()); }
                return b;
            
        }).collect(Collectors.toList());
        
    }
}
