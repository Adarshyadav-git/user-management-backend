package com.example.user_management.service;


import com.example.user_management.dto.UserRequest;
import com.example.user_management.dto.UserResponse;
import com.example.user_management.entity.Role;

import java.util.List;

public interface UserService {
    UserResponse register(UserRequest request);
    boolean validateUser(String email, String password);
    String login(String email, String password);
    String getRoleByEmail(String email);
    List<UserResponse> getAllUsers();
    void deleteUser(Long id);
    UserResponse updateUserRole(Long id, Role role);
    UserResponse getUserById(Long id);


    UserResponse getCurrentUser();


}

