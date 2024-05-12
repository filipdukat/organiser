package com.github.filipdukat.organiser.service;

import com.github.filipdukat.organiser.model.User;
import com.github.filipdukat.organiser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
