package com.template.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.entity.NotificationTokenEntity;
import com.template.entity.UserEntity;

@Repository
public interface NotificationTokensRepository extends JpaRepository<NotificationTokenEntity, Integer> {
	
	List<NotificationTokenEntity> findByUserId(UserEntity userExample);
}
