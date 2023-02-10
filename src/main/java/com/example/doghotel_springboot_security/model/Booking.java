package com.example.doghotel_springboot_security.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Pattern(regexp = "[A-Za-z]+", message = "Разрешены только латинские буквы!")
    @Size(min = 2, max = 20, message = "Поле должно содержать от 2 до 20 символов!")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Поле обязательно для заполнения!")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "date_in")
    private Date dateIn;

    @NotNull(message = "Поле обязательно для заполнения!")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "date_out")
    private Date dateOut;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
