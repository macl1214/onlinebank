package com.cubas.onlinebank.dao;

import java.util.List;

import com.cubas.onlinebank.entity.User;

public interface UserDao {

	public List<User> getUsers();
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User save(User user);
}
