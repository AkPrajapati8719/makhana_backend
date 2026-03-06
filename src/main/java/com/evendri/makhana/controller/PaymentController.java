package com.evendri.makhana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "https://makhana-frontend-psi.vercel.app/")
public class PaymentController {

    // here the Razorpay key id and secret will be stored securely (for demo, we are
    // hardcoding it here)
    private final String KEY_ID = "YOUR_RAZORPAY_KEY_ID";
    private final String KEY_SECRET = "YOUR_RAZORPAY_KEY_SECRET";

    // here we are creating an API endpoint to create an order in Razorpay when the
    // user clicks on "Pay Now" button in the frontend
    @PostMapping("/create-order")
    public ResponseEntity<?> createRazorpayOrder(@RequestBody Map<String, Object> data) {
        try {
            // here the total amount
            int amount = Integer.parseInt(data.get("amount").toString());

            // here we will integrate Razorpay SDK to create an order and get the order id,
            // but for now we will just print the amount and return a dummy response
            System.out.println("Initiating secure payment for ₹" + amount);

            // this is a dummy response, in real implementation we will return the order id
            // and other details from Razorpay
            return ResponseEntity.ok("Order Created Securely. Proceed to Payment Gateway.");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Payment initiation failed: " + e.getMessage());
        }
    }
}