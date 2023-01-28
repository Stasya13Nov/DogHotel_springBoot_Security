package com.example.doghotel_springboot_security.controller;

import com.example.doghotel_springboot_security.model.Role;
import com.example.doghotel_springboot_security.model.User;
import com.example.doghotel_springboot_security.repository.UserRepository;
import com.example.doghotel_springboot_security.service.RoleService;
import com.example.doghotel_springboot_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;
    private final RoleService roleService;
    private final UserRepository userRepository;

    @GetMapping
    public String getAllInfo(){
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute("user") User user) {
//        user.setRoles(Collections.singleton(new Role("USER")));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.save(user);
        return "success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }




}
