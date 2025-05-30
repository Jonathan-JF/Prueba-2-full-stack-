package com.ethicaia.ethicaia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethicaia.ethicaia.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

