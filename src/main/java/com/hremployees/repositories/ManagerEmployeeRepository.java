package com.hremployees.repositories;

import com.hremployees.entities.ManagerEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerEmployeeRepository extends JpaRepository<ManagerEmployee, Long> {
    Page<ManagerEmployee> findAll(Pageable pageable);
    List<ManagerEmployee> findAll();
}
