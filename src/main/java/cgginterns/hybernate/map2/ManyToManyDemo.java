package cgginterns.hybernate.map2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Emp e1 = new Emp();
		e1.seteId(1);
		e1.seteName("abc");

		Emp e2 = new Emp();
		e2.seteId(2);
		e2.seteName("def");

		Project p1 = new Project();
		p1.setpId(11);
		p1.setpName("Library Management System");

		Project p2 = new Project();
		p2.setpId(12);
		p2.setpName("chatGpt");

		List<Emp> list1 = new ArrayList<>();
		list1.add(e1);
		list1.add(e2);

		List<Project> list2 = new ArrayList<>();
		list2.add(p1);
		list2.add(p2);

		e1.setProjects(list2);
		p2.setEmployes(list1);

		Session session = factory.openSession();

		session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		session.getTransaction().commit();
		Emp e = session.get(Emp.class,1);
		System.out.println(e.geteName());
		System.out.println(e.geteName());
		session.close();
		factory.close();
		
		
	}
}