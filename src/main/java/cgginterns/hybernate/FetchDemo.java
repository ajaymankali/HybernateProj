package cgginterns.hybernate;

import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
//		//Fetching student data
//		Student s = (Student)session.get(Student.class,1);
//		
//		System.out.println(s);
		
		Address a = (Address)session.get(Address.class, 1);
	
//		System.out.println(a);
		byte[] image = a.getImage();
		try(FileOutputStream fos = new FileOutputStream("src/main/java/FetchedImage.jpg")){
			fos.write(image);
			fos.flush();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		session.close();
		factory.close();
	}

}
