package br.com.amigosecreto.model.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		try{
			Configuration config = new Configuration();
			config.configure("/META-INF/hibernate.cfg.xml");
			return config.buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("falha ao criar objeto SessionFactory");
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	

}
