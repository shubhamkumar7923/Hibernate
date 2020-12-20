package com.abcd;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Demo2 {

	public static void main(String[] args) {
		Configuration con = new Configuration();
		con.configure();
		
		Properties prop = con.getProperties();
		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry sr = srb.applySettings(prop).build();
		
		/*Employee emp = new Employee();
		emp.setNme("shubham");
		emp.setSal(15000);*/
		
		SessionFactory sf = con.buildSessionFactory(sr);
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();
		
		Employee emp1 = (Employee) ses.load(Employee.class, new Integer(1));
		//System.out.println("The Employee name is: "+emp1.getNme());
		//System.out.println("The Employee Salary is: "+emp1.getSal());
		
		/*emp1.setNme("Shubham");
		emp1.setSal(20000);
		ses.update(emp1);
		System.out.println("Updated Successfully");*/
		
		ses.delete(emp1);
		System.out.println("Deleted Successfully");
		
		//ses.save(emp);
		tx.commit();
		ses.close();
		sf.close();
		System.out.println("Insetrted Successfully");
	}

}
