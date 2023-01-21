package com.example.doghotel_springboot_security.repository;

import com.example.doghotel_springboot_security.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
