package com.project.webgiasu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentDTO {
    private Long parentId;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String role; // Vai trò: PARENT
}
