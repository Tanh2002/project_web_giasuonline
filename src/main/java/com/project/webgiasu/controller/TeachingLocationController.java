package com.project.webgiasu.controller;

import com.project.webgiasu.entity.TeachingLocation;
import com.project.webgiasu.service.TeachingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teaching-locations")
public class TeachingLocationController {

    @Autowired
    private TeachingLocationService teachingLocationService;

    @GetMapping
    public ResponseEntity<List<TeachingLocation>> getAllTeachingLocations() {
        List<TeachingLocation> teachingLocations = teachingLocationService.getAllTeachingLocations();
        return new ResponseEntity<>(teachingLocations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeachingLocation> getTeachingLocationById(@PathVariable("id") Long id) {
        Optional<TeachingLocation> teachingLocation = teachingLocationService.getTeachingLocationById(id);
        return teachingLocation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TeachingLocation> createTeachingLocation(@RequestBody TeachingLocation teachingLocation) {
        TeachingLocation savedTeachingLocation = teachingLocationService.saveTeachingLocation(teachingLocation);
        return new ResponseEntity<>(savedTeachingLocation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachingLocation> updateTeachingLocation(@PathVariable("id") Long id, @RequestBody TeachingLocation teachingLocation) {
        if (!teachingLocationService.getTeachingLocationById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teachingLocation.setLocationId(id);
        TeachingLocation updatedTeachingLocation = teachingLocationService.saveTeachingLocation(teachingLocation);
        return new ResponseEntity<>(updatedTeachingLocation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachingLocation(@PathVariable("id") Long id) {
        if (!teachingLocationService.getTeachingLocationById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teachingLocationService.deleteTeachingLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
