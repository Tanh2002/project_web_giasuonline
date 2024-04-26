package com.project.webgiasu.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TeachingLocationDTO {
    private Long locationId;
    private Long tutorId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal radiusKm;
}
