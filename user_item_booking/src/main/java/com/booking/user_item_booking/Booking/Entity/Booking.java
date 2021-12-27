package com.booking.user_item_booking.Booking.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Uid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private LocalDate Starttime;

   // @NonNull 
    private LocalDate Endtime;

    public Booking() {
    }

    public Booking(int uid, int id, LocalDate starttime, LocalDate endtime) {
        Uid = uid;
        this.id = id;
        Starttime = starttime;
        Endtime = endtime;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStarttime() {
        return Starttime;
    }

    public void setStarttime(LocalDate starttime) {
        Starttime = starttime;
    }

    public LocalDate getEndtime() {
        return Endtime;
    }

    public void setEndtime(LocalDate endtime) {
        Endtime = endtime;
    }

    @Override
    public String toString() {
        return "Booking [Endtime=" + Endtime + ", Starttime=" + Starttime + ", Uid=" + Uid + ", id=" + id + "]";
    }

    
}
