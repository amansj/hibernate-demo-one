package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step1:Create Session Factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Step2:Create Session
		Session session=factory.getCurrentSession();
		
		try {
			//use session for java object operation
			
			//start transaction
			session.beginTransaction();
			//save student object
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
		
		
	}

}
