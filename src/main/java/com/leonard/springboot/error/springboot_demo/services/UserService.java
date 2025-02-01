package com.leonard.springboot.error.springboot_demo.services;

import java.util.List;
import java.util.Optional;

import com.leonard.springboot.error.springboot_demo.models.domain.User;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);

}
