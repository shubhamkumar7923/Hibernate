package com.abc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Demo {

	public static void main(String[] args) {
		 SessionFactory sf = MyHibernateUtil.getSessionFactory();
	        Session ses = sf.openSession();
	        Transaction tx = ses.getTransaction();
	        tx.begin();
	        
	        Citizen c = new Citizen();
	        c.setCname("Raj");
	        Passport p = new Passport();
	        p.setPnumber("C7654321");
	        p.setCitizen(c);
	        c.setPassport(p);
	        ses.save(p);
	        tx.commit();
	        ses.close();
	        sf.close();
	}

}
