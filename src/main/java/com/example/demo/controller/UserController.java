package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id){
        if(id == 1){
            return "sys";
        }else if(id == 2){
            return "wh";
        }else{
            return "no body";
        }

    }
}
