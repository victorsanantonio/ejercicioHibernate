package EjercicioHibernate1.controlador;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import EjercicioHibernate1.modelo.Departamento;
import EjercicioHibernate1.modelo.Empleado;
import EjercicioHibernate1.principal.Principal;

public class Modificar {
	private static Logger logger = LogManager.getLogger(Principal.class);
	private Session session;

	private void iniciaOperacion() {
		// SessionFactory sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		logger.info("Modificación iniciada");
	}

	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
		logger.info("Modificación finalizada");
	}

	public void actualizarEmpleado(Empleado empleado) {
		iniciaOperacion();
		session.update(empleado);
		logger.info("Empleado actualizado");
		terminaOperacion();
	}

	public void actualizarDepartamento(Departamento departamento) {
		iniciaOperacion();
		session.update(departamento);
		logger.info("Departamento actualizado");
		terminaOperacion();
	}
}
