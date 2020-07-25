package com.hremployees.repositories;

import com.hremployees.entities.Remuneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RemunirationRepository  extends JpaRepository<Remuneration,Long> {
    List<Remuneration> findAll();

}
