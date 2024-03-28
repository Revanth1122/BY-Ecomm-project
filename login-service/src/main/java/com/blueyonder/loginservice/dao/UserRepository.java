package com.blueyonder.loginservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.loginservice.entities.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	public Optional<UserEntity> findByUsername(String username);

	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);
}