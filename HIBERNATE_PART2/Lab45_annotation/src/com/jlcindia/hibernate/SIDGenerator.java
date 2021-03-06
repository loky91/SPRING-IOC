package com.jlcindia.hibernate;


import java.io.*;
import java.util.*;
import org.hibernate.*;


	public class SIDGenerator{	
		
		public static SID getNextSid(String bid) {
			SID sid=null;
			Transaction tx=null;
			
	try {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		tx=session.beginTransaction();
		
		String hql1="from Student stu where stu.studentid.bid=?";
		Query q1=session.createQuery(hql1);
		
		q1.setString(0,bid);
		
		List l1=q1.list();
		if(l1.size()==0) {
			
			sid=new SID(bid,"001");
		}else {
			
			String hql="select max(stu.studentid.sid) from Student stu where stu.studentid.bid=?";
			Query q=session.createQuery(hql);
			q.setString(0,bid);
			
			String id=q.list().get(0).toString();
			int x=Integer.parseInt(id);

			x=x+1;
			if(x<=9) {
				sid=new SID(bid,"00"+x);
			}else if(x<=99){
				
				sid=new SID(bid,"0"+x);
				
			}else if(x<=999) {
				sid=new SID(bid,""+x);
				
			}
			
		}
		tx.commit();
	}catch(Exception e) {
		if(tx!=null) {
			
			tx.rollback();
		}
		e.printStackTrace();	
		
	}		
			return sid;
		}
	
	
		}

