package com.example.demo.repo;

import com.example.demo.DTO.CupCakeDto;
import com.example.demo.model.CupCake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CupCakeRepo extends JpaRepository<CupCake, String> {
    @Query(value="select count(*) from cup_cake",nativeQuery = true)
    long countUsers();
    @Modifying
    @Query(value="UPDATE cup_cake SET last_touched=?1 where time in(SELECT time FROM cup_cake LIMIT 50)",nativeQuery = true)
    int updateProfile(Date dob);
    @Query(nativeQuery = true)
    List<CupCakeDto> findChildren();
}
