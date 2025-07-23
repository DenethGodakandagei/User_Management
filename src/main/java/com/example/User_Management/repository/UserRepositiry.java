package com.example.User_Management.repository;

import com.example.User_Management.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositiry extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity>findByEmail(String email);

    Boolean existsByEmail(String email);
}
