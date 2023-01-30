package com.example.doghotel_springboot_security.controller;

import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping("/{userId}/bookings")
    public String userBooking(@PathVariable int userId, Model model){
        User user = userService.findById(userId);
        model.addAttribute("currentUser", user);
        model.addAttribute("bookings", user.getBookingList());
        return "booking/allBooking";
    }



}
