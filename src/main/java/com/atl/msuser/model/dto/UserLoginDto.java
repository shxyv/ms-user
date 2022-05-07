package com.atl.msuser.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
