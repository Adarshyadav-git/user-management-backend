package com.example.user_management.Dto;

import com.example.user_management.Entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUpdateRequest {
    private Role role;
}
