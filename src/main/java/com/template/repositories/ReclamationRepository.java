package com.template.repositories;

import com.template.entity.ReclamationEntity;
import com.template.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<ReclamationEntity, Integer> {
    UserEntity findByEmail(String email);
}
