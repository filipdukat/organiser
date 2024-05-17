package com.github.filipdukat.organiser.controller;

import com.github.filipdukat.organiser.model.Profile;
import com.github.filipdukat.organiser.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@Tag(name = "Profile Controller", description = "API for managing profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    @Operation(summary = "Get all profiles", description = "Retrieve a list of all profiles")
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }
}
