package com.example.doghotel_springboot_security.service;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;;

@Service
@AllArgsConstructor
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(int id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void delete(int id) {
        bookingRepository.deleteById(id);
    }
}
