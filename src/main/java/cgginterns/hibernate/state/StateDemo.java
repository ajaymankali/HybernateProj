package cgginterns.hibernate.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hybernate.Certificate;
import cgginterns.hybernate.Student;

public class StateDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		//creating students objects
		
		Student st1 = new Student();
		st1.setId(1414);
		st1.setName("PQR");
		st1.setCity("secd");
		st1.setCerti(new Certificate("Android","2months"));
		
		//student is in transient state
		
		Session s = factory.openSession();
		 s.beginTransaction();
		//Persistent:session,database;
		s.save(st1);
		//student:Removed State
		s.getTransaction().commit();
		s.close();
//		st1.setName("DEF");
//		System.out.println(st1.getName());
		factory.close();
		
	}
}
