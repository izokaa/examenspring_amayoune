package com.hremployees.services;

import com.hremployees.entities.Remuneration;
import com.hremployees.exceptions.ResourceNotFoundException;
import com.hremployees.repositories.RemunirationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RemunerationServiceImpl implements RemunerationService {

    @Autowired
    private RemunirationRepository remunirationRepository;

    @Override
    public List<Remuneration> getAllRumuneration() {
        List<Remuneration> all = remunirationRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public Remuneration findById(long id) throws ResourceNotFoundException {
        return remunirationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(Remuneration remuneration) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        remuneration.setCreated(timestamp);
        remunirationRepository.save(remuneration);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        remunirationRepository.deleteById(id);
    }
}
