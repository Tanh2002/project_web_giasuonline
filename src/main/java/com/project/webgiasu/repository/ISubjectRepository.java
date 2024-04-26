package com.project.webgiasu.repository;

import com.project.webgiasu.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<Subject, Long> {
}
