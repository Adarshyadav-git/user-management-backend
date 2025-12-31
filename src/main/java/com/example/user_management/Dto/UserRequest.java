package com.example.user_management.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class UserRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

}
