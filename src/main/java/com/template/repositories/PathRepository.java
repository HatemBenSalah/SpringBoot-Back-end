package com.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.entity.PathEntity;

@Repository
public interface PathRepository extends JpaRepository<PathEntity, Integer>{

}
