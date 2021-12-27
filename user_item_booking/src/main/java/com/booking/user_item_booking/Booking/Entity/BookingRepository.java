package com.booking.user_item_booking.Booking.Entity;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking,Integer>{
    
    @Query(value = "select * from Booking",nativeQuery = true)
    public ArrayList<Booking> getAllBooking();
    
}
