package com.github.filipdukat.organiser.controller;

import com.github.filipdukat.organiser.model.Profile;
import com.github.filipdukat.organiser.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }
}
