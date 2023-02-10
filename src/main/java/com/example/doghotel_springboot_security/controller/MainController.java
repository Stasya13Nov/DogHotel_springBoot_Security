package com.example.doghotel_springboot_security.controller;

import com.example.doghotel_springboot_security.model.Booking;
import com.example.doghotel_springboot_security.model.Rating;
import com.example.doghotel_springboot_security.model.Role;
import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.repository.UserRepository;
import com.example.doghotel_springboot_security.service.BookingService;
import com.example.doghotel_springboot_security.service.RatingService;
import com.example.doghotel_springboot_security.service.RoleService;
import com.example.doghotel_springboot_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;


@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;
    private final BookingService bookingService;
    private final RatingService ratingService;

    @GetMapping
    public String getAllInfo(){
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "register";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        return "success";
    }

    @GetMapping("/users") //для админа
    public String listUsers(Model model, @Param("prefix") String prefix) {
        List<User> listUsers = userService.findByPrefix(prefix);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("prefix", prefix);
        return "users";
    }
    @GetMapping("/allUsersBookings")//для админа
    public String listBookings(Model model, @Param("prefix") String prefix){
        List<Booking> listBookings = bookingService.findByPrefix(prefix);
        model.addAttribute("bookings", listBookings);
        model.addAttribute("prefix", prefix);
        return "allUsersBookings";
    }

    @GetMapping("/allRatings")//для админа
    public String listRatings(Model model, @Param("prefix") String prefix){
        List<Rating> listRatings = ratingService.findByPrefix(prefix);
        model.addAttribute("ratings", listRatings);
        model.addAttribute("prefix", prefix);
        return "allRatings";
    }


    @GetMapping("/403")
    public String error403(){
        return "403";
    }



}
