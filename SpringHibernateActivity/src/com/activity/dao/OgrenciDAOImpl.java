package com.activity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.model.Etkinlik;
import com.activity.model.Ogrenci;

@Repository
public class OgrenciDAOImpl implements OgrenciDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}
		
	@Override
	public void addOgrenci(Ogrenci ogrenci,Etkinlik etkinlik) {
		
		Session session = getCurrentSession();		
	    //etkinlik.addOgrenci(ogrenci);
		session.saveOrUpdate(ogrenci);  		
	}

	@Override
	public List<Ogrenci> getOgrenciler() {
		Session session = getCurrentSession();
		TypedQuery<Ogrenci> query = session.createQuery("from Ogrenci", Ogrenci.class);
		return query.getResultList();
	}

	@Override
	public Ogrenci getOgrenci(int id) {
		Session session = getCurrentSession();
		Ogrenci ogrenci = session.get(Ogrenci.class, id);
		return ogrenci;
	}

	@Override
	public void deleteOgrenci(int id) {
	
	   	Session session = getCurrentSession();
	    Ogrenci ogrenci = (Ogrenci) session.get(Ogrenci.class, new Integer(id));
		
	  	  if(ogrenci != null){
			 session.delete(ogrenci);
		  }
	  	  
	 }	

}
