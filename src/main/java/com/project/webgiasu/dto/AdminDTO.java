package com.project.webgiasu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
    private Long adminId;
    private String username;
    private String password;
    private String email;
    private String role; // Vai trò: ADMIN
}
