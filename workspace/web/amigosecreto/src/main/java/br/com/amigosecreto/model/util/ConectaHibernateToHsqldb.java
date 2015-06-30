package br.com.amigosecreto.model.util;

import org.hibernate.Session;

public class ConectaHibernateToHsqldb {

		public static void main(String[] args){
			Session session = null;
			
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				System.out.println("conectou");
			} finally {
				session.close();
			}
			
			
		}
}
