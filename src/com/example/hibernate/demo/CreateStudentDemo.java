package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step1:Create Session Factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Step2:Create Session
		Session session=factory.getCurrentSession();
		
		try {
			//use session for java object operation
			System.out.println("Student object Creation...");
			//create a Student object
			Student stud1=new Student("S","j","sj@abc.com");
			Student stud2=new Student("B","S","abc@gmail.com");
			Student stud3=new Student("C","D","cdd@gmail.com");
			//start transaction
			session.beginTransaction();
			//save student object
			System.out.println("Saving Student");
			session.save(stud1);
			session.save(stud2);
			session.save(stud3);
			//commit transaction
			session.getTransaction().commit();
			/*session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println(stud.getId());
			Student abc=session.get(Student.class,stud.getId());
			System.out.println(abc);
			session.getTransaction().commit();*/
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
		
		
	}

}
