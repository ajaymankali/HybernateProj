package cgginterns.hybernate.map1;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BrandProductMapDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// creating a Brand
		Brand brand = new Brand();
		brand.setBrandId(1);
		brand.setBrandName("Tata");

		// creating the products of tata

		Product pro = new Product();
		pro.setProductId(001);
		pro.setProductName("tata_salt");
		pro.setBrands(brand);
		// creating another product of tata

		Product pro1 = new Product();
		pro1.setProductId(002);
		pro1.setProductName("tata_tea");
		
		ArrayList<Product> list = new ArrayList<>();
		list.add(pro);
		list.add(pro1);
		brand.setProducts(list);
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(brand);
		session.save(pro);
		session.save(pro1);
		
		session.getTransaction().commit();
		
		Brand b = new Brand();
		System.out.println(b.getBrandName());
		session.close();
		factory.close();
	}
}
