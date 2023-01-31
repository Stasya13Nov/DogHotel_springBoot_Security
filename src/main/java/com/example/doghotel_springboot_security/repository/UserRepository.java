package com.example.doghotel_springboot_security.repository;

import com.example.doghotel_springboot_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE "
            + "CONCAT(u.id, u.firstName, u.lastName, u.email)"
            + " LIKE %?1% order by u.id")
    List<User> search(String prefix);

}
