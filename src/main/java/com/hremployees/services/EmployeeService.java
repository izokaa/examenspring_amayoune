package com.hremployees.services;

import com.hremployees.entities.Employee;
import com.hremployees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    Employee findById(long id) throws ResourceNotFoundException;

    void save(Employee employee);

    void deleteById(long id);
}
