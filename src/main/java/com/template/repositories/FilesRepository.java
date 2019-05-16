package com.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.entity.FilesEntity;

@Repository
public interface FilesRepository extends JpaRepository<FilesEntity, Integer> {

}
