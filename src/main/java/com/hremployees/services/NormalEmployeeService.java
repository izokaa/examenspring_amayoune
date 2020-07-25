package com.hremployees.services;

import com.hremployees.entities.ManagerEmployee;
import com.hremployees.entities.NormalEmployee;
import com.hremployees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface NormalEmployeeService {

    public List<NormalEmployee> getAllNormalEmployee();

    NormalEmployee findById(long id) throws ResourceNotFoundException;

    void save(NormalEmployee employee);

    void deleteById(long id);

    void updateById(long id, ManagerEmployee employee) throws ResourceNotFoundException;
}
