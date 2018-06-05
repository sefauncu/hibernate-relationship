package com.activity.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.activity.model.Baskan;
import com.activity.model.Etkinlik;
import com.activity.model.Kulup;
import com.activity.model.Ogrenci;

public class ActivityTest {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Baskan.class)
								.addAnnotatedClass(Kulup.class)
								.addAnnotatedClass(Etkinlik.class)
								.addAnnotatedClass(Ogrenci.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
						
			// create a course
			Etkinlik tempEtkinlik = new Etkinlik("Hibernate","Relationship","Istanbul");
						
			// save the course
			System.out.println("\nSaving the course ...");
			session.save(tempEtkinlik);
			System.out.println("Saved the course: " + tempEtkinlik);
			
			// create the students
			Ogrenci tempStudent1 = new Ogrenci("John", "john@luv2code.com");
			Ogrenci tempStudent2 = new Ogrenci("Mary", "mary@luv2code.com");
						
			// add students to the course
			tempEtkinlik.addOgrenci(tempStudent1);
			tempEtkinlik.addOgrenci(tempStudent2);
			
			// save the students
			System.out.println("\nSaving students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempEtkinlik.getOgrencis());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}
}
