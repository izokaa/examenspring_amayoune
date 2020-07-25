package com.hremployees.services;

import com.hremployees.entities.User;
import com.hremployees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService{

    public List<User> getAllUser();

    User findById(long id) throws ResourceNotFoundException;

    void save(User user);

    void deleteById(long id);
}
