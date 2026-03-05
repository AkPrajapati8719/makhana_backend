package com.evendri.makhana.repository;

import com.evendri.makhana.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method: find user by email for authentication
    Optional<User> findByEmail(String email);
}