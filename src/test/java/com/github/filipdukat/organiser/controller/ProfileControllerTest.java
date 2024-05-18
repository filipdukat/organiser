package com.github.filipdukat.organiser.controller;

import com.github.filipdukat.organiser.model.Profile;
import com.github.filipdukat.organiser.model.Task;
import com.github.filipdukat.organiser.service.ProfileService;
import com.github.filipdukat.organiser.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfileController.class)
class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService profileService;

    @Test
    void getAllProfiles() throws Exception{
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, "username1", "pass1"),
                new Profile(2L, "username2", "pass2"));
        when(profileService.getAllProfiles()).thenReturn(profiles);

        mockMvc.perform(get("/profiles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].username").value("username1"))
                .andExpect(jsonPath("$[0].password").value("pass1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].username").value("username2"))
                .andExpect(jsonPath("$[1].password").value("pass2"));
    }
}