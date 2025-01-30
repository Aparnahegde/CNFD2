package hibe_example;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Hibernate_example {

	public Session getSession() {
		SessionFactory sf = new Configuration().configure("hibernate-config.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		return s;
	}
	
	public void insert(int id, String name, String usn, String address, int totmarks) {
		Student s = new Student();
		s.setName(name);
		s.setUsn(usn);
		s.setAddress(address);
		s.setTotmarks(totmarks);
		Session ses = getSession();
		Transaction t = ses.beginTransaction();
		ses.save(s);
		t.commit();
		ses.close();
	}
	

	public void delete(String name) {
		Session s = getSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("delete from Student where name =:name");
		q.setParameter("name", name);
		int status = q.executeUpdate();
		if(status == 0) {
			System.out.println("No record found with name to delete" );
		}else {
			System.out.println("Deleted ");
		}
		t.commit();
		s.close();
		
	}
	
	public List<Student> display(){
		Session s =getSession();
		Query<Student> q = s.createQuery("from Student");
		List<Student> slist = q.getResultList();
		System.out.println(slist);
		s.close();
		return slist;
	}
	
	public void search(String name) {
		Session s = getSession();
		Query q = s.createQuery("from Student as s where s.name =:name");
		q.setParameter("name", name);
		List<Student> stud= q.getResultList();
		System.out.println(stud);
		s.close();
		
	}
	
	
	public static void main(String[] args) {
		Hibernate_example sm = new Hibernate_example();
		
		Scanner sc = new Scanner(System.in);
		
		lp: while(true) {
			System.out.println("\nMenu"
					+ "\n1: Insert \n2: Delete \n3: Search "
					+ "\n4:Display \n7:Exit \nEnter your Choice");
			int ch = sc.nextInt();
			switch(ch) {
			case 1: 
				System.out.println("enter id");
				int id = sc.nextInt();
				System.out.println("enter usn");
				String usn = sc.next();
				System.out.println("enter name");
				String name = sc.next();
				System.out.println("enter address");
				String address = sc.next();
				System.out.println("enter totMarks");
				int totmarks = sc.nextInt();
				sm.insert(id, name, usn, address, totmarks);
				break;
			case 2:
				System.out.print("Enter studnet name to delete");
				name = sc.next();
				sm.delete(name);
				break;
			case 3:
				System.out.println("enter name to search");
				name = sc.next();
				sm.search(name);
				break;
			case 4: 
				sm.display();
				break;
			case 7:
				break lp;
			default:
					System.out.println("Invalid choice");
			}
		}
	}
}
