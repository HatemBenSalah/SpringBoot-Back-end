package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.entity.AppSettingsEntity;

@Repository
public interface AppSettingsRepository extends JpaRepository<AppSettingsEntity, Integer> {

}
