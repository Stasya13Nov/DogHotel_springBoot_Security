package com.example.doghotel_springboot_security.controller;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.model.Category;
import com.example.doghotel_springboot_security.model.Rating;
import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.service.BookingService;
import com.example.doghotel_springboot_security.service.CategoryService;
import com.example.doghotel_springboot_security.service.RatingService;
import com.example.doghotel_springboot_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor

public class RatingController {
    private final BookingService bookingService;
    private final RatingService ratingService;
    private final UserService userService;

    @GetMapping("rating")
    public String rating(Model model){
        model.addAttribute("rating", new Rating());
        List<Booking> listBookings = userService.currentUser().getBookingList();
        model.addAttribute("listBookings", listBookings);
        return "rating";
    }

    @PostMapping("successfulRating")
    public String saveRating(@Valid Rating rating, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "rating";
        }
        ratingService.save(rating);
        return "redirect:/successfulRating";
    }

    @GetMapping("/successfulRating")
    public String successfulRating(Model model){
        User user = userService.currentUser();
        model.addAttribute("currentUser", user);
        return "successfulRating";
    }


}

