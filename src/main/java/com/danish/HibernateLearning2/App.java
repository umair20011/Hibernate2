package com.danish.HibernateLearning2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
    	Laptop laptop=new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	Student s=new Student();
    	s.setName("Danish");
    	s.setRollno(1);
    	s.setMarks(50);
    	s.getLaptop().add(laptop);
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        
        session.save(laptop);
        session.save(s);
        tx.commit();
    }
}
