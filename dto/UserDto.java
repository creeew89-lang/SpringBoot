package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class UserDto {
    @NotBlank String name;
    @NotBlank String email;

}
