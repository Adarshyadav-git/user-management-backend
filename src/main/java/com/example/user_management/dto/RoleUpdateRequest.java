package com.example.user_management.dto;

import com.example.user_management.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUpdateRequest {
    private Role role;
}
