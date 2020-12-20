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
        c.setCname("ANand");
        Passport p = new Passport();
        p.setPnumber("A1234567");
        c.setPassport(p);
        ses.save(c);
        
        tx.commit();
        ses.close();
        sf.close();
    }
 }