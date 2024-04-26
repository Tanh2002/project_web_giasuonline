package com.project.webgiasu.service;

import com.project.webgiasu.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {
    List<Admin> getAllAdmins();

    Optional<Admin> getAdminById(Long id);

    Admin saveAdmin(Admin admin);

    void deleteAdmin(Long id);
}
