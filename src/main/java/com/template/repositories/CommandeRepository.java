package com.template.repositories;
import com.template.entity.CommandeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, Integer>{

}
