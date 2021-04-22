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
import EjercicioHibernate1.vista.Menu;

public class Consultar {
	private static Logger logger = LogManager.getLogger(Principal.class);
	private Session session;

	public Empleado obtenerEmpleado(int idEmpleado) {
		Empleado empleado = null;
		session = Menu.sessionFactory.openSession();
		empleado = (Empleado) session.get(Empleado.class, idEmpleado);
		logger.info("Empleado obtenido a partir del id: "+idEmpleado);
		return empleado;
	}

	public List<Empleado> listarEmpleados() {
		List<Empleado> empleados = null;
		session = Menu.sessionFactory.openSession();
		empleados = session.createQuery("from Empleado").list();
		logger.info("Empleados listados correctamente");
		return empleados;
	}

	public Departamento obtenerDepartamento(int idDepartamento) {
		Departamento departamento = null;
		session = Menu.sessionFactory.openSession();
		departamento = (Departamento) session.get(Departamento.class, idDepartamento);
		logger.info("Departamento obtenido a partir del id: "+idDepartamento);
		return departamento;
	}

	public List<Departamento> listarDepartamentos() {
		List<Departamento> departamentos = null;
		session = Menu.sessionFactory.openSession();
		departamentos = session.createQuery("from Departamento").list();
		logger.info("Departamentos listados correctamente");
		return departamentos;
	}
}
