package com.project.webgiasu.service;

import com.project.webgiasu.entity.Tutor;
import com.project.webgiasu.repository.ITutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService implements ITutorService {

    @Autowired
    private ITutorRepository tutorRepository;

    @Override
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    @Override
    public Optional<Tutor> getTutorById(Long id) {
        return tutorRepository.findById(id);
    }

    @Override
    public Tutor saveTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}
