package com.example.doghotel_springboot_security.controller;

import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}/bookings")
    public String userBookings(@PathVariable int userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("bookings", user.getBookingList());
        model.addAttribute("currentUser", user);
        return "booking/allBooking";
    }
}
