package com.github.filipdukat.organiser.service;

import com.github.filipdukat.organiser.model.Profile;
import com.github.filipdukat.organiser.model.Task;
import com.github.filipdukat.organiser.repository.ProfileRepository;
import com.github.filipdukat.organiser.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProfileServiceTest {
    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileService profileService;

    @Test
    void getAllProfiles() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, "username1", "pass1"),
                new Profile(2L, "username2", "pass2"));
        when(profileRepository.findAll()).thenReturn(profiles);

        List<Profile> result = profileService.getAllProfiles();

        assertEquals(2, result.size());

        assertEquals(1L, result.get(0).getId());
        assertEquals("username1", result.get(0).getUsername());
        assertEquals("pass1", result.get(0).getPassword());

        assertEquals(2L, result.get(1).getId());
        assertEquals("username2", result.get(1).getUsername());
        assertEquals("pass2", result.get(1).getPassword());
    }
}