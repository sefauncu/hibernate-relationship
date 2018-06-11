package com.activity.dao;

import java.util.List;

import com.activity.model.User;

public interface UserDAO {

	
	public void addUser(User user);
	
	public List<User> getUsers();
	
	public User getUser(int id);
	
	public void deleteUser(int id);
}
