package com.example.doghotel_springboot_security.service;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.repository.BookingRepository;
import com.example.doghotel_springboot_security.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(int id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public Booking save(Booking booking) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        booking.setUser(user);
        return bookingRepository.save(booking);
    }

    public void delete(int id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> findByPrefix(String prefix) {
        if (prefix!=null) {
            return bookingRepository.search(prefix);
        }
        else {
            return bookingRepository.findAll();
        }
    }
}
