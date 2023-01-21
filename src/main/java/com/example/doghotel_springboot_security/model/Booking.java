package com.example.doghotel_springboot_security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "age")
    private int age;
}
