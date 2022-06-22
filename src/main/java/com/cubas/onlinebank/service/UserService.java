package com.cubas.onlinebank.service;

import java.util.List;

import com.cubas.onlinebank.dto.UserDto;
import com.cubas.onlinebank.entity.User;
import com.cubas.onlinebank.validation.UserAlreadyExistException;

public interface UserService {
	
	public List<User> getUsers();
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;
}
