package com.example.doghotel_springboot_security.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @FutureOrPresent(message = "Введите корректные данные. Дата уже прошла")
    @Column(name = "date_in")
    private Date dateIn;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Future(message = "Введите корректные данные. Дата уже прошла")
    @Column(name = "date_out")
    private Date dateOut;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
