package com.project.webgiasu.service;

import com.project.webgiasu.entity.Class;
import com.project.webgiasu.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService {

    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Class> getClassById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public Class saveClass(Class classObj) {
        return classRepository.save(classObj);
    }

    @Override
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
