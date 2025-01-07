package com.example.backend.repository;

import com.example.backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
    Optional<UserModel> findByEmail(String email);
}
