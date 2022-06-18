package com.cubas.onlinebank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubas.onlinebank.dao.UserDao;
import com.cubas.onlinebank.entity.User;

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

}
