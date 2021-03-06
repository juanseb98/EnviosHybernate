package dao;

import org.hibernate.Session;

import ajustesHibernate.HibernateUtil;

public class GenericDAO<T> {
	public void guardar(T entidad) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(entidad);
		session.getTransaction().commit();

	}
	
	public  void borrar(T entidad) throws Exception{
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(entidad);
		session.getTransaction().commit();
	}

}
