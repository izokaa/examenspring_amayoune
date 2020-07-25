package com.hremployees.services;

import com.hremployees.entities.Remuneration;
import com.hremployees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface RemunerationService {

    public List<Remuneration> getAllRumuneration();

    Remuneration findById(long id) throws ResourceNotFoundException;

    void save(Remuneration remuneration);

    void deleteById(long id);
}
