package com.example.doghotel_springboot_security.controller;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.model.Category;
import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.repository.BookingRepository;
import com.example.doghotel_springboot_security.service.BookingService;
import com.example.doghotel_springboot_security.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    private final CategoryService categoryService;
    private final BookingRepository bookingRepository;

    @GetMapping
    public String index(){
        return "booking/index";
    }

    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Category> listCategories = categoryService.findAll();
        model.addAttribute("listCategories", listCategories);
        return "booking/categories";
    }

    @GetMapping("/new")
    public String bookingForm(Model model){
        model.addAttribute("booking", new Booking());
        List<Category> listCategories = categoryService.findAll();
        model.addAttribute("listCategories", listCategories);
        return "booking/bookingForm";
    }

    @PostMapping("/save")
    public String saveBooking(Booking booking){
        bookingService.save(booking);
        return "booking/successfulBooking";
    }

    @GetMapping("/successfulBooking")
    public String successfulBooking(){
        return "booking/successfulBooking";
    }

    @GetMapping("/allBooking")
    public String listBookings(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentName = authentication.getName();

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            String username = ((UserDetails)principal).getUsername();
//        } else {
//            String username = principal.toString();
//        }
        List<Booking> listBookings = bookingService.findAll();
        model.addAttribute("listBookings", listBookings);
        return "booking/allBooking";
    }

    @GetMapping("/edit/{id}")
    public String editBooking(@PathVariable("id") int id, Model model){
        Booking booking = bookingRepository.findById(id).get();
        model.addAttribute("booking", booking);
        List<Category> listCategories = categoryService.findAll();
        model.addAttribute("listCategories", listCategories);
        return "booking/bookingForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable("id") int id, Model model){
        bookingService.delete(id);
        return "redirect:/booking/allBooking";
    }



}
