package com.hremployees.services;

import com.hremployees.entities.ManagerEmployee;
import com.hremployees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ManageremployeeService {
    public List<ManagerEmployee> getAllManagerEmployee();

    ManagerEmployee findById(long id) throws ResourceNotFoundException;

    void save(ManagerEmployee employee);

    void deleteById(long id);
}
