package com.activity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.model.Baskan;



@Repository
public class BaskanActivityDAOImpl implements BaskanActivityDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void addBaskan(Baskan baskan) {
		
		Session session = getCurrentSession();
		session.saveOrUpdate(baskan);
	
		}

	@Override
	
	public List<Baskan> getBaskanlar() {

		Session session = getCurrentSession();
		TypedQuery<Baskan> query = session.createQuery("from Baskan", Baskan.class);
		return query.getResultList();
	}

	@Override
	public Baskan getBaskan(int baskanId) {
		Session session = getCurrentSession();
		Baskan baskan = session.get(Baskan.class, baskanId);
		return baskan;

	}

	@Override
	public void deleteBaskan(int baskanId) {
	
		  Session session = getCurrentSession();
		  Baskan baskan = (Baskan) session.get(Baskan.class, new Integer(baskanId));
		  if(baskan.getKulup() != null){			  
			 baskan.getKulup().setBaskan(null);
		  }	 
		
	  	  if(baskan != null){
			 session.delete(baskan);
		  }
          
	
	
	}

}
