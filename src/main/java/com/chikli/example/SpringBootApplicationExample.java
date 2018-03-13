package com.chikli.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
public class SpringBootApplicationExample {

    //@RequestMapping("/")
    //@ResponseBody
    //String home() {
        //return "Hello World!";
    //}

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationExample.class, args);
    }
}

