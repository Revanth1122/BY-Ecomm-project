package com.blueyonder.loginservice.service;


import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.blueyonder.loginservice.entities.UserEntity;
import com.blueyonder.loginservice.exceptions.PasswordMismatchException;
import com.blueyonder.loginservice.exceptions.UserNameNotFoundException;
import com.blueyonder.loginservice.repositories.LoginRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private LoginRepository userRepository;
	//private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserEntity createUser(UserEntity user) throws PasswordMismatchException  {
		if(user.getPassword1().equals(user.getPassword2()))
		{
			UserEntity  user1 =   userRepository.save(user);
			//logger.info("User created successfully!");
			return user1;
		}
		else {
			//logger.error("Passwords do not match");
			throw new PasswordMismatchException();
		}
		
	}

	@Override
	public UserEntity findByUserName(String username) throws UserNameNotFoundException {
		return userRepository.findByusername(username);
	}

	@Override
	public UserEntity validateUser(String username, String password) throws UserNameNotFoundException,PasswordMismatchException{
		
		UserEntity result = findByUserName(username);
		if(result!=null)
		{
			if(password.equals(result.getPassword1()))
			{
				return result;
			}
			else {
				throw new PasswordMismatchException();
			}
		}
		else {
			//logger.debug("Username "+username+"doesn't exist");
			throw new UserNameNotFoundException();
		}
	}

	
	

}
