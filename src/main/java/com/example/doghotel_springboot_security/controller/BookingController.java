package com.example.doghotel_springboot_security.controller;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.model.Category;
import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.service.BookingService;
import com.example.doghotel_springboot_security.service.CategoryService;
import com.example.doghotel_springboot_security.service.UserService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/booking")
@Slf4j
public class BookingController {
    private final BookingService bookingService;
    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping
    public String index(Model model){
        User user = userService.currentUser();
        model.addAttribute("currentUser", user);
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
    public String saveBooking(@Valid Booking booking, BindingResult bindingResult, Model model) {
        log.info(booking.toString());
        if (bindingResult.hasErrors()){
            log.error(bindingResult.getAllErrors().toString());
            return "booking/bookingForm";
        }
//        bookingService.checkFreeRoom(dateIn, dateOut, category);
        log.info("No errors :)");
        bookingService.save(booking);
        return "redirect:/booking/successfulBooking";
    }

    @GetMapping("/successfulBooking")
    public String successfulBooking(Model model){
        User user = userService.currentUser();
        model.addAttribute("currentUser", user);
        return "booking/successfulBooking";
    }

    @GetMapping("/edit/{id}")
    public String editBooking(@PathVariable("id") int id, Model model){
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        List<Category> listCategories = categoryService.findAll();
        model.addAttribute("listCategories", listCategories);
        return "booking/bookingForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable("id") int id){
        bookingService.delete(id);
        return "redirect:/booking/delete";
    }
    @GetMapping("/delete")
    public String delete(Model model){
        User user = userService.currentUser();
        model.addAttribute("currentUser", user);
        return "booking/delete";
    }



}
