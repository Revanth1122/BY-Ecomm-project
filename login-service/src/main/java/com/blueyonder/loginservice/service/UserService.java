package com.blueyonder.loginservice.service;

import com.blueyonder.loginservice.entities.UserEntity;
import com.blueyonder.loginservice.exceptions.PasswordMismatchException;
import com.blueyonder.loginservice.exceptions.UserNameNotFoundException;

public interface UserService {
	
	public UserEntity createUser(UserEntity user) throws PasswordMismatchException;
	public UserEntity findByUserName(String username) throws UserNameNotFoundException;
	public UserEntity validateUser(String username,String password) throws UserNameNotFoundException,PasswordMismatchException;
		
}
