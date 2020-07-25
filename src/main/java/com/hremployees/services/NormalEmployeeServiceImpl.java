package com.hremployees.services;

import com.hremployees.entities.ManagerEmployee;
import com.hremployees.entities.NormalEmployee;
import com.hremployees.exceptions.ResourceNotFoundException;
import com.hremployees.repositories.NormalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class NormalEmployeeServiceImpl implements NormalEmployeeService {

    @Autowired
    private NormalEmployeeRepository normalEmployeeRepository;

    @Override
    public List<NormalEmployee> getAllNormalEmployee() {
        List<NormalEmployee> all = normalEmployeeRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public NormalEmployee findById(long id) throws ResourceNotFoundException {
        return normalEmployeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(NormalEmployee employee) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        employee.setCreated(timestamp);
        employee.setModified(timestamp);
        employee.setScore(0);
        normalEmployeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        normalEmployeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateById(long id, ManagerEmployee employee) throws ResourceNotFoundException {

        normalEmployeeRepository.updateById(id,employee);
    }
}
