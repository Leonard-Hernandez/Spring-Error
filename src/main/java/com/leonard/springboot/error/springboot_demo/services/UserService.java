package com.leonard.springboot.error.springboot_demo.services;

import java.util.List;

import com.leonard.springboot.error.springboot_demo.models.domain.User;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

}
