package com.activity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.model.Ogrenci;
import com.activity.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		
		Session session = getCurrentSession();		
	   	session.saveOrUpdate(user);  	
		
	}

	@Override
	public List<User> getUsers() {
		Session session = getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User", User.class);
		return query.getResultList();
	}

	@Override
	public User getUser(int id) {
		Session session = getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
	
	  	Session session = getCurrentSession();
	  	User user = (User) session.get(User.class, new Integer(id));
		
	  	  if(user != null){
			 session.delete(user);
		  }
		
	}

}
