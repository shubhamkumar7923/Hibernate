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
        
      /* Query q = ses.createQuery("from Employee");
       List li = q.list();
       for(Object obj : li){
    	   Employee e = (Employee) obj;
    	   System.out.println("Employee Id: "+e.getEmpid());
    	   System.out.println("Employee Name: "+e.getEname());
    	   System.out.println("Employee Email: "+e.getEmail());
    	   System.out.println("Employee department name: "+e.getDepartment().getDname());
    	   System.out.println("------------------------------------------------");
        
       }*/
       /* Query q = ses.createQuery("select e.empid,e.ename,e.email from Employee e");
        List li = q.list();
        for(Object obj : li){
        	Object[] ao = (Object[]) obj;
        	 System.out.println("Employee Id: "+ao[0]);
      	   System.out.println("Employee Name: "+ao[1]);
      	   System.out.println("Employee Email: "+ao[2]);
      	   System.out.println("------------------------------------------------");
        }*/
        /*Query q = ses.createQuery("select e.empid,e.ename,e.email from Employee e order by e.ename desc");
        List li = q.list();
        for(Object obj : li){
        	Object[] ao = (Object[]) obj;
           System.out.println("Employee Id: "+ao[0]);
      	   System.out.println("Employee Name: "+ao[1]);
      	   System.out.println("Employee Email: "+ao[2]);
      	   System.out.println("------------------------------------------------");
        }*/
       /* Query q = ses.createQuery("from Employee where ename ='bond'");
        List li = q.list();
        for(Object obj : li){
        	Employee e = (Employee) obj;
     	   System.out.println("Employee Id: "+e.getEmpid());
     	   System.out.println("Employee Name: "+e.getEname());
     	   System.out.println("Employee Email: "+e.getEmail());
     	   System.out.println("Employee department name: "+e.getDepartment());
      	   System.out.println("------------------------------------------------");
        } */
        Query q= ses.createQuery("select e.empid, e.ename, d.dname from Employee e , Department d");
        List li=q.list();
        for(Object obj: li)
        {
        	Object[] ao=(Object[] )obj;
        	System.out.println("emp id is:"+ao[0]);
        	System.out.println("emp name is:"+ao[1]);
        	System.out.println("emp dept is:"+ao[2]);
        	System.out.println("--------------------------------------------------");
        }	
	}

}
