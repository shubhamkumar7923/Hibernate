package com.abc;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Demo {

	public static void main(String[] args) {
		
		Configuration con = new Configuration();
		con.configure();
		Properties prop = con.getProperties();
		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry sr = srb.applySettings(prop).build();
		
//		Employee emp = new Employee();
//		emp.setNme("Shubham");
//		emp.setSal(5000);
		
		SessionFactory sf = con.buildSessionFactory(sr);
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		
		Employee emp1 = (Employee) ses.load(Employee.class, new Integer(1));
		//System.out.println("The employee name is :"+ emp1.getNme());
		//System.out.println("The employee name is :"+ emp1.getSal());
		emp1.setNme("Kish");
		emp1.setSal(1221);
		ses.update(emp1);
		ses.delete(emp1);
		tx.begin();
	//	ses.save(emp);
		tx.commit();
		ses.close();
		sf.close();
		System.out.println("Inserted successfully");
	}

}
