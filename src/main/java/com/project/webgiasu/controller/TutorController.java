package com.project.webgiasu.controller;

import com.project.webgiasu.entity.Tutor;
import com.project.webgiasu.service.ITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

    @Autowired
    private ITutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> getAllTutors() {
        List<Tutor> tutors = tutorService.getAllTutors();
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable("id") Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        return tutor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor savedTutor = tutorService.saveTutor(tutor);
        return new ResponseEntity<>(savedTutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable("id") Long id, @RequestBody Tutor tutor) {
        if (!tutorService.getTutorById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tutor.setTutorId(id);
        Tutor updatedTutor = tutorService.saveTutor(tutor);
        return new ResponseEntity<>(updatedTutor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable("id") Long id) {
        if (!tutorService.getTutorById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tutorService.deleteTutor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
