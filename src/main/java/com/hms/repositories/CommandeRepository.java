package com.hms.repositories;
import com.hms.entity.CommandeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, Integer>{

}
