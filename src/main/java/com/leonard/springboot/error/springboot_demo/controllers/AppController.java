package com.leonard.springboot.error.springboot_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonard.springboot.error.springboot_demo.models.domain.User;
import com.leonard.springboot.error.springboot_demo.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping("/show")
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("1a0");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User findUserById(@PathVariable(name = "id") Long id){

        return service.findById(id);

    }
}
