package EjercicioHibernate1.controlador;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import EjercicioHibernate1.modelo.Departamento;
import EjercicioHibernate1.modelo.Empleado;
import EjercicioHibernate1.principal.Principal;

public class Consultar {
	private static Logger logger = LogManager.getLogger(Principal.class);
	private Session session;

	private void iniciaOperacion() {
		// SessionFactory sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		logger.info("Consulta iniciada");
	}

	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
		logger.info("Consulta finalizada");
	}

	public Empleado obtenerEmpleado(int idEmpleado) {
		Empleado empleado = null;
		iniciaOperacion();
		empleado = (Empleado) session.get(Empleado.class, idEmpleado);
		logger.info("Empleado obtenido a partir del id: "+idEmpleado);
		terminaOperacion();
		return empleado;
	}

	public List<Empleado> listarEmpleados() {
		List<Empleado> empleados = null;
		iniciaOperacion();
		empleados = session.createQuery("from Empleado").list();
		logger.info("Empleados listados correctamente");
		terminaOperacion();
		return empleados;
	}

	public Departamento obtenerDepartamento(int idDepartamento) {
		Departamento departamento = null;
		iniciaOperacion();
		departamento = (Departamento) session.get(Departamento.class, idDepartamento);
		logger.info("Departamento obtenido a partir del id: "+idDepartamento);
		terminaOperacion();
		return departamento;
	}

	public List<Departamento> listarDepartamentos() {
		List<Departamento> departamentos = null;
		iniciaOperacion();
		departamentos = session.createQuery("from Departamento").list();
		terminaOperacion();
		logger.info("Departamentos listados correctamente");
		return departamentos;
	}
}
