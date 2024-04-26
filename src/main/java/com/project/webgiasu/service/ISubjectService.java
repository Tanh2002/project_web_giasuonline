package com.project.webgiasu.service;

import com.project.webgiasu.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    List<Subject> getAllSubjects();

    Optional<Subject> getSubjectById(Long id);

    Subject saveSubject(Subject subject);

    void deleteSubject(Long id);
}
