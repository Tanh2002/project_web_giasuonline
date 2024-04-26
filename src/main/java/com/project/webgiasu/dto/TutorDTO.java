package com.project.webgiasu.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TutorDTO {
    private Long tutorId;
    private String username;
    private String password;
    private String fullName;
    private BigDecimal price;
    private String email;
    private String role; // Vai trò: TUTOR
}
