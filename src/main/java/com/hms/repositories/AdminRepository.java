package com.hms.repositories;
import java.util.Optional;

import com.hms.entity.AdminEntity;
import com.hms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByEmail(String email);
    Boolean existsByEmail(String email);



}
