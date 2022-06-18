package com.cubas.onlinebank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cubas.onlinebank.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> getUsers() {
		
		TypedQuery theQuery = entityManager.createQuery("FROM User",
														User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}
	
	@Override
	public User findByUsername(String username) {
		
		Query theQuery = entityManager.createQuery("FROM User "
												 + "WHERE username=:uName");
		
		theQuery.setParameter("uName", username);
		
		User user = null;
		
		try {
			user = (User) theQuery.getSingleResult();
		} catch(Exception e) {
			System.out.println("User with username: " + username + " not found.");
		}
		
		return user;
	}

	@Override
	public User findByEmail(String email) {

		Query theQuery = entityManager.createQuery("FROM User "
												 + "WHERE email=:em");
		
		theQuery.setParameter("em", email);
		
		User user = null;
		
		try {
			user = (User) theQuery.getSingleResult();
		} catch (Exception e) {
			System.out.println("User with email: " + email + " not found.");
		}
		
		return user;
	}

	
}
