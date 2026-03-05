package com.evendri.makhana.service;

import com.evendri.makhana.model.Order;
import com.evendri.makhana.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // place new order
    public Order createOrder(Order order) {
        // when order is placed set the date and status automatically
        order.setOrderDate(LocalDateTime.now());

        if (order.getOrderStatus() == null) {
            order.setOrderStatus("PENDING"); // show pending by default whenever order not shipping
        }

        return orderRepository.save(order);
    }

    // find orders by user id and show in user profile
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // get all orders for admin dashboard of all users and show in admin dashboard
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // admin can update order status to shipping, delivered, cancelled etc
    public Order updateOrderStatus(Long orderId, String newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        order.setOrderStatus(newStatus);
        return orderRepository.save(order);
    }
}