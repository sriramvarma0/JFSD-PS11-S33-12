package com.example.touristhomestayplatform.service;

import com.example.touristhomestayplatform.model.User;
import com.example.touristhomestayplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Check if username or email is taken
    public boolean isUsernameOrEmailTaken(String username, String email) {
        return userRepository.findByUsername(username).isPresent() ||
               userRepository.findByEmail(email).isPresent();
    }

    // Register a new user
    public void registerUser(User user) {
        if (isUsernameOrEmailTaken(user.getUsername(), user.getEmail())) {
            throw new IllegalArgumentException("Username or email is already taken.");
        }
        userRepository.save(user); // Save without password encryption
    }

    // Login user by verifying credentials
    public boolean authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
