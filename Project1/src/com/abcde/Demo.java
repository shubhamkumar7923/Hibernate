package com.abcde;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Demo {
    public static void main(String[] args) {
        SessionFactory sf = MyHibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.getTransaction();
        tx.begin();
        
    /*    Citizen c = new Citizen();
        c.setCname("Shubham");
        Passport p = new Passport();
        p.setPnumber("A123792");
        c.setPassport(p);
        ses.save(c);*/
        
        /*Citizen cz = (Citizen)ses.load(Citizen.class, new Integer(2));
        System.out.println("Citizen Id is :"+cz.getCid());
        System.out.println("Citizen Name is :"+cz.getCname());
        System.out.println("Citizen Passport no :"+cz.getPassport().getPnumber());*/
        
        Passport ps = (Passport)ses.load(Passport.class, new Integer(1));
        System.out.println("Passport Id:"+ps.getPid());
        System.out.println("Passport Number:"+ps.getPnumber());
        
        tx.commit();
        ses.close();
        sf.close();
    }
 }
