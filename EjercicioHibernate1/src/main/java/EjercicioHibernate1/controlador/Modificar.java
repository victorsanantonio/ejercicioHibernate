package EjercicioHibernate1.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import EjercicioHibernate1.modelo.Departamento;
import EjercicioHibernate1.modelo.Empleado;

public class Modificar {
	private Session session;

	private void iniciaOperacion() {
		// SessionFactory sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
	}

	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
	}
	
	public void actualizarEmpleado(Empleado empleado) {
		iniciaOperacion();
		session.update(empleado);
		terminaOperacion();
	}
	
	public void actualizarDepartamento(Departamento departamento) {
		iniciaOperacion();
		session.update(departamento);
		terminaOperacion();
	}
}
