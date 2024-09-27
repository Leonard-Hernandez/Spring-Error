package com.leonard.springboot.error.springboot_demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/app")
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("1a0");
        System.out.println(value);
        return "ok 200";
    }
}
