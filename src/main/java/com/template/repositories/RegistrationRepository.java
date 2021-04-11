package com.template.repositories;

import java.util.List;
import java.util.Optional;

import com.template.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.template.entity.UserEntity;


@Repository
public interface RegistrationRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
    //UserEntity findByEmail(String email);




}
