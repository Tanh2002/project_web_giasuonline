package com.project.webgiasu.controller;

import com.project.webgiasu.entity.Admin;
import com.project.webgiasu.entity.Class;
import com.project.webgiasu.service.ClassService;
import com.project.webgiasu.service.IAdminService;
import com.project.webgiasu.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private IClassService classService;

    @GetMapping
    public ResponseEntity<List<Class>> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable("id") Long id) {
        Optional<Class> admin = classService.getClassById(id);
        return admin.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Class> createClass(@RequestBody Class classes) {
        Class savedClass = classService.saveClass(classes);
        return new ResponseEntity<>(savedClass, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable("id") Long id, @RequestBody Class classes) {
        if (!classService.getClassById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classes.setClassId(id);
        Class updatedClass = classService.saveClass(classes);
        return new ResponseEntity<>(updatedClass, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable("id") Long id) {
        if (!classService.getClassById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
