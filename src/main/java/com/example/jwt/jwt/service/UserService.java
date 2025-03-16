package com.example.jwt.jwt.service;

import com.example.jwt.jwt.domain.Role;
import com.example.jwt.jwt.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName,String roleName);
    User getUser(String userName);
    List<User> getUsers();

}
