package com.example.user_management.Controller;

import com.example.user_management.Config.JwtUtil;
import com.example.user_management.Dto.JwtResponse;
import com.example.user_management.Dto.LoginRequest;
import com.example.user_management.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {


        boolean valid = userService.validateUser(
                request.getEmail(),
                request.getPassword()
        );

        if (!valid) {
            throw new RuntimeException("Invalid credentials");
        }

        // fetch role
        String role = userService.getRoleByEmail(request.getEmail());

        // pass email + role
        String token = jwtUtil.generateToken(request.getEmail(), role);
        return new JwtResponse(token);
    }

}