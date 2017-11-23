package com.mkyong.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static final String ANNOTATION = "ANNOTATION";
	public static final String XML = "XML";

   
  /*  private static final SessionFactory annSessionFactory = buildAnnSessionFactory();
    private static final SessionFactory sessionFactory = buildSessionFactory();
   
    */

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private static SessionFactory buildAnnSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(String confType) {
        return (ANNOTATION.equals(confType)?buildAnnSessionFactory():buildSessionFactory());
    }

    public static void shutdown() {
    	// Close caches and connection pools
    	//getSessionFactory().close();
    }

}