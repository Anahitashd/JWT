package com.example.jwt.jwt.service;

import com.example.jwt.jwt.domain.Role;
import com.example.jwt.jwt.domain.User;
import com.example.jwt.jwt.repo.RoleRepo;
import com.example.jwt.jwt.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

    }

    @Override
    public User getUser(String userName) {
        return null;
    }

    @Override
    public List<User> getUser() {
        return List.of();
    }
}
