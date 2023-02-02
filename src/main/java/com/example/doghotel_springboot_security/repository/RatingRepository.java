package com.example.doghotel_springboot_security.repository;

import com.example.doghotel_springboot_security.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query("SELECT r FROM Rating r WHERE "
            + "CONCAT(r.id, r.text, r.user.id, r.booking.id)"
            + " LIKE %?1% order by r.id")
    List<Rating> search(String prefix);
}
