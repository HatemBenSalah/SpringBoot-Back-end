package com.template.repositories;
import com.template.entity.EmployeEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EmployeRepository extends JpaRepository<EmployeEntity, Integer> {
}
