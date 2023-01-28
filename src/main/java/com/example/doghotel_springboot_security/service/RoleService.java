package com.example.doghotel_springboot_security.service;

import com.example.doghotel_springboot_security.model.Role;
import com.example.doghotel_springboot_security.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
}
