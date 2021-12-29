package com.booking.user_item_booking.Booking.Entity;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking,Integer>{
    
    @Query(value = "select * from Booking",nativeQuery = true)
    public ArrayList<Booking> getAllBooking();

    @Modifying
    @Query(value="update Booking b set b.Uid=:m,  b.id= :i , b.StartTime= :s , b.EndTime= :e  where b.Uid= :u", nativeQuery = true)
    public void updateBooking(@Param("m") int Uid,@Param("i") int id,@Param("s") LocalDate start,@Param("e") LocalDate end,@Param("u") int uid);
    
    @Modifying
    @Query(value = "insert into Booking (id, StartTime,EndTime) values(:i ,:s,:e)",nativeQuery = true)
    public void addBooking(@Param("i") int id,@Param("s") LocalDate start,@Param("e") LocalDate end);
}
