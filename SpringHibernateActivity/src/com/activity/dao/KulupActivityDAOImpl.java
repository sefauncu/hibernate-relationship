package com.activity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import com.activity.model.Baskan;
import com.activity.model.Kulup;

@Repository
public class KulupActivityDAOImpl implements KulupActivityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public void addKulup(Kulup kulup,Baskan baskan) {
	
		Session session = getCurrentSession();
		kulup.addBaskan(kulup,baskan);
		session.saveOrUpdate(kulup);
	
	    
	}


	@Override
	public List<Kulup> getKulupler() {
		
		Session session = getCurrentSession();
		TypedQuery<Kulup> query = session.createQuery("from Kulup", Kulup.class);
		return query.getResultList();
	}
	

	@Override
	public Kulup getKulup(int kulupId) {
		Session session = getCurrentSession();
		
        Kulup kulup = session.get(Kulup.class,kulupId);
		
		return kulup;
	}

	@Override
	public void deleteKulup(int kulupId) {
		 Session session = getCurrentSession();
		 Kulup kulup = session.get(Kulup.class,kulupId);
		 
		 if(kulup != null){
			 session.delete(kulup);
		 }
	
	 }
	

}
