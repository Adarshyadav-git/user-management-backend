package com.example.user_management.Controller;

import com.example.user_management.Dto.LoginRequest;
import com.example.user_management.Dto.LoginResponse;
import com.example.user_management.Dto.UserRequest;
import com.example.user_management.Dto.UserResponse;
import com.example.user_management.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody UserRequest request){
        return userService.register(request);
    }

    @GetMapping("/me")
    public UserResponse me() {
        return userService.getCurrentUser();
    }
}

