package com.example.doghotel_springboot_security.service;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.model.Rating;
import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.repository.RatingRepository;
import com.example.doghotel_springboot_security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }


    public Rating save(Rating rating) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        rating.setUser(user);
        return ratingRepository.save(rating);
    }

    public List<Rating> findByPrefix(String prefix) {
        if (prefix!=null) {
            return ratingRepository.search(prefix);
        }
        else {
            return ratingRepository.findAll();
        }
    }
}
