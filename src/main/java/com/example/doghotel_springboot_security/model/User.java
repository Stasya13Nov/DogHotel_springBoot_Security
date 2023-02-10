package com.example.doghotel_springboot_security.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Разрешены латинские буквы и символы ._%+-")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Size(min = 4, message = "Пароль должен содержать от 4 символов!")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Size(min = 2, max = 50, message = "Поле должно содержать от 2 до 50 символов!")
    @Pattern(regexp = "[A-Za-z]+", message = "Разрешены только латинские буквы!")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Size(min = 2, max = 50, message = "Поле должно содержать от 2 до 50 символов!")
    @Pattern(regexp = "[A-Za-z]+", message = "Разрешены только латинские буквы!")
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

}
