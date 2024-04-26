package com.project.webgiasu.service;

import com.project.webgiasu.entity.TeachingLocation;

import java.util.List;
import java.util.Optional;

public interface ITeachingLocationService {
    List<TeachingLocation> getAllTeachingLocations();

    Optional<TeachingLocation> getTeachingLocationById(Long id);

    TeachingLocation saveTeachingLocation(TeachingLocation location);

    void deleteTeachingLocation(Long id);
}
