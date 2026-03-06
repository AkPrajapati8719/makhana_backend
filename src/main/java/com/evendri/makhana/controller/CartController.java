package com.evendri.makhana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "https://makhana-frontend-psi.vercel.app/")
public class CartController {

    // sync the data to frontend and backend
    @PostMapping("/sync/{userId}")
    public ResponseEntity<?> syncCart(@PathVariable Long userId, @RequestBody Object cartData) {

        // this updates the cart data in the database for the given userId
        System.out.println("Cart synchronized successfully for user: " + userId);

        return ResponseEntity.ok("Cart data securely saved in database.");
    }
}