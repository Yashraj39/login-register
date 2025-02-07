package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.userEntry;

public interface userRepository extends MongoRepository<userEntry,String> {
    public abstract userEntry findByUsername(String username);
}
