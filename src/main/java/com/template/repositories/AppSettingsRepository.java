package com.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.entity.AppSettings;

@Repository
public interface AppSettingsRepository extends JpaRepository<AppSettings, Integer> {

}
