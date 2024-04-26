package com.project.webgiasu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tutors")
@Getter
@Setter
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorId;

    @Column(unique = true)
    private String username;

    private String password;

    private String fullName;

    @ManyToMany
    @JoinTable(
            name = "tutor_subjects",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    private BigDecimal price;

    @OneToMany(mappedBy = "tutor")
    private List<TeachingLocation> teachingLocations;

}

