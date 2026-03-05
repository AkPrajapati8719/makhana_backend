package com.evendri.makhana.service;

import com.evendri.makhana.model.User;
import com.evendri.makhana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // register new user with email uniqueness check and default role assignment
    public User registerUser(User user) {
        // check if email already exist in the database
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exist!");
        }

        // new user get default role as "ROLE_USER" if role is not provided
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        }

        return userRepository.save(user);
    }

    // find user by email for authentication (important for login)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
