package cgginterns.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hybernate.Student;

public class HqlDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// HQL
		// Syntax

		String query = "from Student as s where s.city = :x and s.name=:n";
		Query q = session.createQuery(query);
		q.setParameter("x", "Hyd");
		q.setParameter("n", "ajay");
		List<Student> list = q.list();
		for (Student s : list) {
			System.out.println(s.getName()+" " +s.getCity()+" ");
		}
		session.close();
		factory.close();
	}
}
