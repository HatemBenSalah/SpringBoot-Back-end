package com.template.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.entity.RolesEntity;

@Repository
public interface RoleRepository extends JpaRepository<RolesEntity, Integer> {

	List<RolesEntity> findBydescription(String description);
}
