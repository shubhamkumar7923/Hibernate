package com.abc;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Demo {

	public static void main(String[] args) {
		SessionFactory sf = MyHibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.getTransaction();
        tx.begin();
        
        /* Citizen c = new Citizen();
        c.setCname("Shubham");
        Passport p = new Passport();
        p.setPnumber("A1234567");
        p.setCitizen(c);
        c.setPassport(p);
        ses.save(p);*/
        
        Passport ps = (Passport)ses.load(Passport.class, new Integer(1));
        System.out.println("Passport Id:"+ps.getPid());
        System.out.println("Passport Number:"+ps.getPnumber());
        System.out.println("Customer Name :"+ps.getCitizen().getCname());
      
        
        tx.commit();
        ses.close();
        sf.close();
	}

}
