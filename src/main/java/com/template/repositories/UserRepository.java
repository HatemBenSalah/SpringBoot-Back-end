package com.template.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.template.entity.RolesEntity;
import com.template.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	List<UserEntity> findByemail(String email);
	List<UserEntity> findByisDeleted(Boolean isDeleted);
	List<UserEntity> findByrole(RolesEntity role);
	
}
