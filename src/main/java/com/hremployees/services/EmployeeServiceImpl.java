package com.hremployees.services;

import com.hremployees.entities.Employee;
import com.hremployees.entities.ManagerEmployee;
import com.hremployees.entities.NormalEmployee;
import com.hremployees.exceptions.ResourceNotFoundException;
import com.hremployees.repositories.EmployeeRepository;
import com.hremployees.repositories.ManagerEmployeeRepository;
import com.hremployees.repositories.NormalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerEmployeeRepository managerEmployeeRepository;
    @Autowired
    private NormalEmployeeRepository normalEmployeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public Employee findById(long id) throws ResourceNotFoundException {
        NormalEmployee  normalEmployee = null;
        ManagerEmployee managerEmployee = null ;
        try {
            managerEmployee = managerEmployeeRepository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException(id)
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            normalEmployee = normalEmployeeRepository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException(id)
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        if(managerEmployee == null){
            System.out.println("normal: "+normalEmployee);
            return normalEmployee;
        }else{
            System.out.println("manager: "+managerEmployee);
            return managerEmployee;
        }
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        employee.setCreated(timestamp);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}
