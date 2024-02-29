package com.fullstack.employee.leave.management.system.repository;

import com.fullstack.employee.leave.management.system.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email);
}
