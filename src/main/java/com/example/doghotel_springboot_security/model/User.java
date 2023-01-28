package com.example.doghotel_springboot_security.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList;

//    public void addBookingToUser(Booking booking){
//        if (bookingList==null){
//            bookingList = new ArrayList<>();
//        }
//        bookingList.add(booking);
//        booking.setUser(this);
//    }
}
