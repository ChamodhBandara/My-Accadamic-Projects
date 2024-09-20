package com.fullstack.employee.leave.management.system.repository.auth_repository;

import com.fullstack.employee.leave.management.system.auth_model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
