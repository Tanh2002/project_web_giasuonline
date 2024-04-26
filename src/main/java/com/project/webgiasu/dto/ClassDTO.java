package com.project.webgiasu.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ClassDTO {
    private Long classId;
    private Long parentId;
    private Long tutorId;
    private Long subjectId;
    private LocalDateTime schedule;
    private BigDecimal price;
    private String address;
    private String status;
}
