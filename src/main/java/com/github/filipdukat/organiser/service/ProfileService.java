package com.github.filipdukat.organiser.service;

import com.github.filipdukat.organiser.model.Profile;
import com.github.filipdukat.organiser.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }
}
