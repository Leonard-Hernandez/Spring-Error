package com.leonard.springboot.error.springboot_demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonard.springboot.error.springboot_demo.models.domain.User;

@Service
public class UserServiceImpl implements UserService {
    
    private List<User> users;

    @Autowired
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst(); 
    }
}
