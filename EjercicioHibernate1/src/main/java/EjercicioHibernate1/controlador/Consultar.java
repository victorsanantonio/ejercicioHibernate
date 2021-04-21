package EjercicioHibernate1.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Consultar {
	private Session session;
	
	private void iniciaOperacion() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
	}
	
	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
	}
}
