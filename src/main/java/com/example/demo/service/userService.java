package com.example.demo.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.userEntry;
import com.example.demo.repository.userRepository;

@Service
public class userService {
    
    @Autowired
    private userRepository userRepository;

    public userEntry saveUser(userEntry userEntry){
        return userRepository.save(userEntry);
    }

    public userEntry findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<userEntry> getall(){
        return userRepository.findAll();
    }

    public userEntry login(userEntry userEntry){
        userEntry user = userRepository.findByUsername(userEntry.getUsername());
        if(user!=null && user.getPassword().equals(userEntry.getPassword())){
            return user;
        }
        return null;
    }
}
