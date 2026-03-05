package com.evendri.makhana.repository;

import com.evendri.makhana.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom method: specific users order history
    List<Order> findByUserId(Long userId);
}