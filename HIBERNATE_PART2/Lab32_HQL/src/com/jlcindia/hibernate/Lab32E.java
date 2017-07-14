package com.jlcindia.hibernate;

import java.util.*;
import org.hibernate.*;



public class Lab32E {

	public static void main(String args[]) {
		Transaction tx=null;
		try {
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			tx=session.beginTransaction();
			
			//A> DISPLAY the CUSTOMERS by Email
			
			String hql="from Customer cust where cust.email=?";
			Query query=session.createQuery(hql);
			query.setString(0,"sri@jlc.com");
			
			Customer cust=(Customer)query.uniqueResult();
				System.out.println(cust);
			
			tx.commit();
			session.close();
			
			
			
			
			
			
		}catch(Exception e) {
			if(tx!=null) {
				
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	
}