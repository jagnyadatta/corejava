package com.mkyong.common;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mkyong.persistence.HibernateUtil;
import com.websystique.hibernate.model.Student;

public class HQLTest {
	public static void main(String[] args) {
		 Session session =  HibernateUtil.getSessionFactory(HibernateUtil.ANNOTATION).openSession();
         Query query=session.createQuery("from Student ");
         query.setFirstResult(0);
         query.setMaxResults(1);
    
      List<Student> stocks= new ArrayList<>();
  for (int i = 0; i < 4; i++) {
	  System.out.println("********************");
	  query.setFirstResult(i);
      query.setMaxResults(2);
   stocks=   query.list();
   stocks.stream().forEach(System.out::println);
	
}
      
      
      
	}

}
