package com.leonard.springboot.error.springboot_demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leonard.springboot.error.springboot_demo.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl(){
        this.users = new ArrayList<>();
        users.add(new User(1L, "Leonard", "Hernandez"));
        users.add(new User(2L, "Lubraska", "Ferreira"));
        users.add(new User(3L, "Andres", "Guzman"));
        users.add(new User(4L, "Carlos", "gomez"));
        users.add(new User(5L, "Jose", "Gutierrez"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        for(User u: users){
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        System.out.println(user.getName());
        return user;
    }



}
