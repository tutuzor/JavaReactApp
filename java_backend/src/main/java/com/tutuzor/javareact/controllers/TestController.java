package com.tutuzor.javareact.controllers;

import com.tutuzor.javareact.models.User;
import com.tutuzor.javareact.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/test")
    public String test(){
        return "Hey Wolrds";
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void addMember(@RequestBody User user){
        userRepo.save(user);
    }

    @GetMapping("/get_all")
    public Long getAllUsers(){
        return userRepo.count();
    }
}
