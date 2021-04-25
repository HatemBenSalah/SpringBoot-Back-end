package com.hms.repositories;
import com.hms.entity.CommandeEntity;
import com.hms.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, Integer>{
    Optional<CommandeEntity> findByEmail(String email);
    Boolean existsByEmail(String email);
}
