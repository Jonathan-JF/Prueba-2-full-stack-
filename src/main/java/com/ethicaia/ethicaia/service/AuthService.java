package com.ethicaia.ethicaia.service;

import com.ethicaia.ethicaia.model.User;
import com.ethicaia.ethicaia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.isPresent() && userOpt.get().getPassword().equals(password);
    }
}

