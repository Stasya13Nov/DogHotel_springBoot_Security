package com.example.doghotel_springboot_security.service;

import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int userId) {
        return userRepository.findById(userId).orElseThrow();
    }
    public User currentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email);
    }

    public List<User> findByPrefix(String prefix) {
        if (prefix!=null) {
            return userRepository.search(prefix);
        }
        else {
            return userRepository.findAll();
        }
    }
}
