package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.userEntry;
import com.example.demo.service.userService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class userController {
    
    @Autowired
    private userService userService;

    @PostMapping("/register")
    public String register(@RequestBody userEntry userEntry){
        System.out.println("Received user: " + userEntry.getUsername());
        userEntry savedUser = userService.saveUser(userEntry);
        return savedUser != null ? "User Registered Successfully" : "Registration Failed";
    }

    @GetMapping
    public List<userEntry> getAll() {
        return userService.getall() ;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody userEntry userEntry) {
        try {
        userEntry loggedUser = userService.login(userEntry);
        if (loggedUser != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred. Please try again.");
    }
    }
    
}
