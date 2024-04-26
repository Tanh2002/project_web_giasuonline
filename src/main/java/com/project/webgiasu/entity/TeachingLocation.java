package com.project.webgiasu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "teaching_locations")
@Getter
@Setter
public class TeachingLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal radius;
}
