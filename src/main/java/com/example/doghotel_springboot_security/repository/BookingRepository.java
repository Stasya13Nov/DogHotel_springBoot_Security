package com.example.doghotel_springboot_security.repository;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("SELECT b FROM Booking b WHERE "
            + "CONCAT(b.id, b.category.name, b.user.lastName, b.name)"
            + " LIKE %?1% order by b.id")
    List<Booking> search(String prefix);




}
