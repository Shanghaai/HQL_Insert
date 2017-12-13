package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class InsertClient {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();
		
		  OldStudent os = new OldStudent(); os.setAddress("mumbai");
		  os.setId(125); os.setName("harsh");
		   
		  s.save(os); t.commit(); s.close(); sf.close();
		  System.out.println("data inserted");
		 

		/*String hql = "insert into NewStudent(id,name,address) " + "select s.id,s.name,s.address from OldStudent s";

		Query q = s.createQuery(hql);
		int i = q.executeUpdate();

		System.out.println("rows affected count :" + i);
		System.out.println("data dumped success");

		s.close();
		sf.close();*/
	}
}
