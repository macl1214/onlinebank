package com.cubas.onlinebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubas.onlinebank.dao.UserDao;
import com.cubas.onlinebank.dto.UserDto;
import com.cubas.onlinebank.entity.User;
import com.cubas.onlinebank.validation.UserAlreadyExistException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> getUsers() {
		
		List<User> users =  userDao.getUsers();
		
		return users; 
	}
	
	@Override
	@Transactional
	public User findByUsername(String username) {
		User user = userDao.findByUsername(username);
		
		return user;
	}

	@Override
	@Transactional
	public User findByEmail(String email) {
		User user = userDao.findByEmail(email);
		
		return user;
	}

	@Override
	public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
		if (emailExists(userDto.getEmail())) {
			throw new UserAlreadyExistException("There is an account with this email address: " + userDto.getEmail());
		}
		
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		return userDao.save(user);
	}

	public boolean emailExists(String email) {
		return userDao.findByEmail(email) != null;
	}

}
