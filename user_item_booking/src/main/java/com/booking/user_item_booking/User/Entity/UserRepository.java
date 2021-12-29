package com.booking.user_item_booking.User.Entity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer>{
    
    @Query(value = "select * from user",nativeQuery = true)
    public ArrayList<User> getAllUser();

    @Modifying
    @Query(value="update  User b set b.Uid=:m,  b.Name= :i , b.Email= :s   where b.Uid= :u", nativeQuery = true)
    public void updateUser(@Param("m") int Uid,@Param("i") String Name,@Param("s") String Email,@Param("u") int uid);
    
    @Modifying
    @Query(value = "insert into User (Uid,Name,Email) values(:i ,:s,:e)",nativeQuery = true)
    public void addUser(@Param("i") int Uid,@Param("s") String Name,@Param("e") String Email);
}

