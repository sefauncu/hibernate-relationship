package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activity.dao.UserDAO;
import com.activity.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addUser(User user) {
		
		userDAO.addUser(user);
		
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int id) {
		
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		
		userDAO.deleteUser(id);
		
	}

}
