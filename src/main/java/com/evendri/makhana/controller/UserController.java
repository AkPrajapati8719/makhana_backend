package com.evendri.makhana.controller;

import com.evendri.makhana.model.User;
import com.evendri.makhana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "https://makhana-frontend-psi.vercel.app/") // change with the live url
public class UserController {

    @Autowired
    private UserService userService;

    // react will call this API to register a new user, we will save the user data
    // in the database
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // check the user credentials during login, if valid then return the user data,
    // else return an error message
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginData) {
        User user = userService.getUserByEmail(loginData.getEmail());

        if (user != null && user.getPassword().equals(loginData.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body("Invalid username or password!");
    }
}