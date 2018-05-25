package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class RetreiveStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//Step2:Create Session
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("Retreive");
			List<Student> theStudents=session.createQuery("from Student where"+" email like '%@gmail.com'").list();
			session.getTransaction().commit();
			for(Student s:theStudents)
			{
				System.out.println(s);
			}
		}finally {
			factory.close();
		}
	}

}
