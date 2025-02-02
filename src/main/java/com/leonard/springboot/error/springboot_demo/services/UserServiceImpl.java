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
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        System.out.println(user.getName());
        return Optional.ofNullable(user);
    }
}
