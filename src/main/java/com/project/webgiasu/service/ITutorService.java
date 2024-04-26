package com.project.webgiasu.service;

import com.project.webgiasu.entity.Tutor;

import java.util.List;
import java.util.Optional;

public interface ITutorService {
    List<Tutor> getAllTutors();

    Optional<Tutor> getTutorById(Long id);

    Tutor saveTutor(Tutor tutor);

    void deleteTutor(Long id);
}
