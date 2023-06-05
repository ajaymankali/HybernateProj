package cgginterns.hybernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		System.out.println(factory);
//		System.out.println(factory.isClosed());
		
		Student student = new Student();
		student.setName("ABC");
		student.setId(1);
		student.setCity("Hyd");
		
		//creating Address Object 
		Address ad = new Address();
		ad.setStreet("street5");
		ad.setCity("Hyd");
		ad.setOpen(true);
		ad.setX(12.34);
		ad.setAddDate(new Date());
		
		//Reading Image file and storing in database
		try (FileInputStream fis = new FileInputStream("src/main/java/BruceLee.jpg")){
			byte[] data = new byte[fis.available()];
			fis.read(data);
			ad.setImage(data);
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Session  session=factory.openSession();
		session.beginTransaction();
		session.save(student);
		session.save(ad);
		session.getTransaction().commit();
		session.close();
		factory.close();
		System.out.println("Done...");
	}
}
