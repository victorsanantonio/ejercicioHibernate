package EjercicioHibernate1.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import EjercicioHibernate1.modelo.Departamento;
import EjercicioHibernate1.modelo.Empleado;

public class Borrar {
	private Session session;

	private void iniciaOperacion() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
	}

	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
	}
	
	public void borrarEmpleado(Empleado empleado) {
		iniciaOperacion();
		session.delete(empleado);
		terminaOperacion();
	}
	
	public void borrarDepartamento(Departamento departamento) {
		iniciaOperacion();
		session.delete(departamento);
		terminaOperacion();
	}
}
