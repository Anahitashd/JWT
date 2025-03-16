package com.example.jwt.jwt.repo;

import com.example.jwt.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String username);

}
