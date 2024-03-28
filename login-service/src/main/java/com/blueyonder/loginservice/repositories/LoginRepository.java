package com.blueyonder.loginservice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blueyonder.loginservice.entities.UserEntity;

public interface LoginRepository extends CrudRepository<UserEntity, Integer>{
	/*
		@Query(value = "select * from user_login_details u where u.username= :username and u.password1 = :password",nativeQuery = true)
		public User getUser(@Param("username") String username, @Param("password") String password);
		*/
	public UserEntity findByusername(String username);
}
