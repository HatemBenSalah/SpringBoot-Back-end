package com.hms.repositories;
import com.hms.entity.AdminEntity;
import com.hms.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmail(String email);

    Boolean existsByEmail(String email);
}
