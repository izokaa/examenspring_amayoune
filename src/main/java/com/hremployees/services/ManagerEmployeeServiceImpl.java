package com.hremployees.services;

import com.hremployees.entities.ManagerEmployee;
import com.hremployees.exceptions.ResourceNotFoundException;
import com.hremployees.repositories.ManagerEmployeeRepository;
import com.hremployees.repositories.NormalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ManagerEmployeeServiceImpl implements ManageremployeeService {

    @Autowired
    private ManagerEmployeeRepository managerEmployeeRepository;

    @Autowired
    private NormalEmployeeRepository normalEmployeeRepository;

    @Override
    public List<ManagerEmployee> getAllManagerEmployee() {
        List<ManagerEmployee> all = managerEmployeeRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public ManagerEmployee findById(long id) throws ResourceNotFoundException {
        return managerEmployeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(ManagerEmployee employee) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        employee.setCreated(timestamp);
        employee.setModified(timestamp);
        System.out.println(employee.getNormalEmployees());
        managerEmployeeRepository.save(employee);
       /* for(int i=0 ;i<employee.getNormalEmployees().size();i++){
            normalEmployeeRepository.updateById(i,employee);
        }*/
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        managerEmployeeRepository.deleteById(id);
    }
}
