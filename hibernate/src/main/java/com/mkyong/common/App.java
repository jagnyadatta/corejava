package com.mkyong.common;


import java.util.List;

import org.hibernate.Session;
import com.mkyong.persistence.HibernateUtil;
import com.websystique.hibernate.model.Address;
import com.websystique.hibernate.model.Student;

public class App
{
    public static void main( String[] args )
    {
    	
    	
    	
    	
    	 Student student = new Student("Sam","Disilva","Maths");
         Address address = new Address("10 Silver street","NYC","USA");
          
          
         Session session =  HibernateUtil.getSessionFactory(HibernateUtil.ANNOTATION).openSession();
         session.beginTransaction();
  
        session.persist(address);
        student.setAddress(address);
         session.persist(student);
  
         /*List<Student> students = (List<Student>)session.createQuery("from Student ").list();
         for(Student s: students){
             System.out.println("Details : "+s);
         }
         List<Student> students1 = (List<Student>)session.createQuery("from Student ").list();
         for(Student s: students1){
            // System.out.println("Details : "+s.getAddress());
         }*/
          
         session.getTransaction().commit();
         session.close();  
        System.out.println("Maven + Hibernate + MySQL");
        
        
        
    }
    
    
    public void MKyong()
{Session session = HibernateUtil.getSessionFactory(HibernateUtil.ANNOTATION).openSession();

session.beginTransaction();
Stock stock = new Stock();

stock.setStockCode("001");
stock.setStockName("jagnya001");

session.save(stock);
session.getTransaction().commit();
System.out.println(session.getEntityMode());
System.out.println(session.getStatistics());
System.out.println(session.getIdentifier(stock));}
    
}