package com.github.filipdukat.organiser.repository;

import com.github.filipdukat.organiser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
