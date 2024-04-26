package com.project.webgiasu.service;

import com.project.webgiasu.entity.Parent;

import java.util.List;
import java.util.Optional;

public interface IParentService {
    List<Parent> getAllParents();

    Optional<Parent> getParentById(Long id);

    Parent saveParent(Parent parent);

    void deleteParent(Long id);
}
