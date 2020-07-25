package com.hremployees.services;


import com.hremployees.entities.Role;
import com.hremployees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface RoleService {
    public List<Role> getAllroles();

    Role findById(long id) throws ResourceNotFoundException;

    void save(Role role);

    void deleteById(long id);
}
