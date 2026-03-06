package com.evendri.makhana.controller;

import com.evendri.makhana.model.Order;
import com.evendri.makhana.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "https://makhana-frontend-psi.vercel.app/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // create new order from card page with the checkout button
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    // customers all orders history is here
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        List<Order> orders = orderService.getUserOrders(userId);
        return ResponseEntity.ok(orders);
    }

    // fetch orders for admin dashboard
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        // JpaRepository already has findAll() method that returns all orders from the
        // database
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    // update the order status from admin dashboard
    @PutMapping("/update-status/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        Order updatedOrder = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(updatedOrder);
    }
}