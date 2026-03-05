package com.evendri.makhana.repository;

import com.evendri.makhana.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository automatically provides basic CRUD methods like save(),
    // findById(), findAll(), deleteById(), etc.
}