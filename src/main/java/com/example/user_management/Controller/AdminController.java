package com.example.user_management.Controller;

import com.example.user_management.Dto.RoleUpdateRequest;
import com.example.user_management.Dto.UserResponse;
import com.example.user_management.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    // get all users
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    // get user by id
    @GetMapping("/users/{id}")
    @PreAuthorize("permitAll()")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // delete user
    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    // 3️⃣ UPDATE USER ROLE
    @PutMapping("/users/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse updateUserRole(
            @PathVariable Long id,
            @RequestBody RoleUpdateRequest request
    ) {
        return userService.updateUserRole(id, request.getRole());
    }
}
