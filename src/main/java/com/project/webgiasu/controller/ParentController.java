package com.project.webgiasu.controller;

import com.project.webgiasu.entity.Parent;
import com.project.webgiasu.service.IParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private IParentService parentService;

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable("id") Long id) {
        Optional<Parent> parent = parentService.getParentById(id);
        return parent.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent savedParent = parentService.saveParent(parent);
        return new ResponseEntity<>(savedParent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable("id") Long id, @RequestBody Parent parent) {
        if (!parentService.getParentById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        parent.setParentId(id);
        Parent updatedParent = parentService.saveParent(parent);
        return new ResponseEntity<>(updatedParent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable("id") Long id) {
        if (!parentService.getParentById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        parentService.deleteParent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
