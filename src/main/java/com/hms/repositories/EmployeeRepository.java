package com.hms.repositories;
import com.hms.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
