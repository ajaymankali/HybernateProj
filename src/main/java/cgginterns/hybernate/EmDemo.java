package cgginterns.hybernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// Creating Student Object

		Student s = new Student();
		s.setId(101);
		s.setName("ajay");
		s.setCity("Hyd");

		// Creating a certificate object....

		Certificate certi = new Certificate();
		certi.setCourse("Android");
		certi.setDuration("2 months");

		s.setCerti(certi);

		System.out.println(s);

		// Creating Student Object

		Student s1 = new Student();
		s1.setId(102);
		s1.setName("jay");
		s1.setCity("Hyd");

		// Creating a certificate object....

		Certificate certi1 = new Certificate();
		certi1.setCourse("Android");
		certi1.setDuration("2 months");

		s.setCerti(certi1);

		System.out.println(s1);
		Session session = factory.openSession();
		session.save(s);
		session.save(s1);
		session.beginTransaction();

		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
