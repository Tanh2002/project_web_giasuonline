package com.project.webgiasu.service;

import com.project.webgiasu.entity.TeachingLocation;
import com.project.webgiasu.repository.ITeachingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachingLocationService implements ITeachingLocationService {

    @Autowired
    private ITeachingLocationRepository teachingLocationRepository;

    @Override
    public List<TeachingLocation> getAllTeachingLocations() {
        return teachingLocationRepository.findAll();
    }

    @Override
    public Optional<TeachingLocation> getTeachingLocationById(Long id) {
        return teachingLocationRepository.findById(id);
    }

    @Override
    public TeachingLocation saveTeachingLocation(TeachingLocation location) {
        return teachingLocationRepository.save(location);
    }

    @Override
    public void deleteTeachingLocation(Long id) {
        teachingLocationRepository.deleteById(id);
    }
}
