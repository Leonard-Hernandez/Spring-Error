package com.leonard.springboot.error.springboot_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leonard.springboot.error.springboot_demo.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Leonard", "Hernandez"));
        users.add(new User(2L, "Lubraska", "Ferreira"));
        users.add(new User(3L, "Andres", "Guzman"));
        users.add(new User(4L, "Carlos", "gomez"));
        users.add(new User(5L, "Jose", "Gutierrez"));

        return users;
    }

}
