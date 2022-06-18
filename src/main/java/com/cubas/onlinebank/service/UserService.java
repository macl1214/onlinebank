package com.cubas.onlinebank.service;

import java.util.List;

import com.cubas.onlinebank.entity.User;

public interface UserService {
	
	public List<User> getUsers();
	public User findByUsername(String username);
	public User findByEmail(String email);

}
