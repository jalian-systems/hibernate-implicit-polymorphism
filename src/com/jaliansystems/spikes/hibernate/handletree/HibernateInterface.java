package com.jaliansystems.spikes.hibernate.handletree;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateInterface {
	
	static SessionFactory SESSION_FACTORY ;
	
	static {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void saveEntities(final Object entity)
	{
		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();	
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object> getRecordsOfType(final Class<?> classObject)
	{
		final Session session = SESSION_FACTORY.openSession();
		try {
			return session.createCriteria(classObject).list();
		}
		finally{
			session.close();	
		}
	}

	@SuppressWarnings("unchecked")
	public static <E> E get(E o, long id) {
		final Session session = SESSION_FACTORY.openSession();
		try {
			return (E) session.get(o.getClass(), id);
		}
		finally{
			session.close();	
		}
	}
	
	public static int exectueQuery(final String hqlQuery)
	{
		int effectedRecords=0;
		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		try {
			effectedRecords=session.createQuery(hqlQuery).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();	
		}
		return effectedRecords;
	}
	
  
	
}
