package com.github.filipdukat.organiser.repository;

import com.github.filipdukat.organiser.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
