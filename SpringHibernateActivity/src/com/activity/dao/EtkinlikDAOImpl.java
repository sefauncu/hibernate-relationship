package com.activity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.activity.model.Etkinlik;
import com.activity.model.Kulup;

@Repository
public class EtkinlikDAOImpl implements EtkinlikDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void addEtkinlik(Etkinlik etkinlik,Kulup kulup) {
		
		Session session = getCurrentSession();		
	    etkinlik.addKulup(etkinlik, kulup);
		//kulup.add(etkinlik,kulup);
	    //kulup.add(etkinlik);
		session.saveOrUpdate(etkinlik);
	}

	@Override
	public List<Etkinlik> getEtkinlikler() {
		
		Session session = getCurrentSession();
		TypedQuery<Etkinlik> query = session.createQuery("from Etkinlik", Etkinlik.class);
		return query.getResultList();
	}

	@Override
	public Etkinlik getEtkinlik(int id) {
		Session session = getCurrentSession();
		Etkinlik etkinlik = session.get(Etkinlik.class, id);
		return etkinlik;
	}

	@Override
	public void deleteEtkinlik(int id) {
	   	Session session = getCurrentSession();
	    Etkinlik etkinlik = (Etkinlik) session.get(Etkinlik.class, new Integer(id));
		
	  	  if(etkinlik != null){
			 session.delete(etkinlik);
		  }        
	
	}

}
