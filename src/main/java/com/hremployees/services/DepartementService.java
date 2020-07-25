package com.hremployees.services;

import com.hremployees.entities.Departement;
import com.hremployees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface DepartementService {

    public List<Departement> getAllDeps();

    Departement findById(long id) throws ResourceNotFoundException;

    void save(Departement departement);

    void deleteById(long id);
}
