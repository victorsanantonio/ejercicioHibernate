package EjercicioHibernate1.controlador;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import EjercicioHibernate1.modelo.Departamento;
import EjercicioHibernate1.modelo.Empleado;
import EjercicioHibernate1.principal.Principal;

public class Insertar {
	private static Logger logger = LogManager.getLogger(Principal.class);
	private Session session;

	private void iniciaOperacion() {
		// SessionFactory sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		logger.info("Inserción iniciada");
	}

	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
		logger.info("Inserción finalizada");
	}
	
	public void guardarEmpleado(Empleado empleado) {
		iniciaOperacion();
		session.save(empleado);
		terminaOperacion();
	}
	
	public void guardarDepartamento(Departamento departamento) {
		iniciaOperacion();
		session.save(departamento);
		terminaOperacion();
	}
}
