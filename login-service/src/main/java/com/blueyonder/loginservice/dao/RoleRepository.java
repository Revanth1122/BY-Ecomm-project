package com.blueyonder.loginservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.loginservice.entities.ERole;
import com.blueyonder.loginservice.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(ERole name);
}