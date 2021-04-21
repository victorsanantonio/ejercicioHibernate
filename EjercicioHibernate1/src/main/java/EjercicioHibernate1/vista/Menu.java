package EjercicioHibernate1.vista;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import EjercicioHibernate1.controlador.Consultar;
import EjercicioHibernate1.modelo.Departamento;
import EjercicioHibernate1.modelo.Empleado;
import EjercicioHibernate1.principal.Principal;

public class Menu {
	private static Logger logger = LogManager.getLogger(Principal.class);
	static final int EMPLEADOS = 1;
	static final int DEPARTAMENTOS = 2;
	static final int SALIR = 3;

	static final int CONSULTAR = 1;
	static final int CONSULTAR_POR_ID = 2;
	static final int INSERTAR = 3;
	static final int MODIFICAR = 4;
	static final int BORRAR = 5;
	static final int VOLVER = 6;

	static Scanner sc = new Scanner(System.in);

	static Consultar consultar = new Consultar();

	public void mostrarMenu() {
		System.out.println("\t--GESTIONAR-->");
		System.out.println(EMPLEADOS + ". Empleados");
		System.out.println(DEPARTAMENTOS + ". Departamentos");
		System.out.println(SALIR + ". Salir");
	}

	public void mostrarSubMenu() {
		System.out.println(CONSULTAR + ". Consultar todos los empleados");
		System.out.println(CONSULTAR_POR_ID + ". Consultar por un ID");
		System.out.println(INSERTAR + ". Insertar");
		System.out.println(MODIFICAR + ". Modificar");
		System.out.println(BORRAR + ". Borrar");
		System.out.println(VOLVER + ". Volver");
	}

	public void controlMenu() {
		logger.info("Entrada en el menú");
		int opcion = 0;
		do {
			mostrarMenu();
			opcion = leerInt();
			switch (opcion) {
			case EMPLEADOS:
				System.out.println("\t--EMPLEADOS-->");
				controlSubMenuEmpleados();
				break;
			case DEPARTAMENTOS:
				System.out.println("\t--DEPARTAMENTOS-->");
				controlSubMenuDepartamentos();
				break;
			case SALIR:
				break;
			default:
				System.err.println("Opción no válida");
				logger.error("Se ha introducido una opción no válida");
			}
		} while (opcion != SALIR);
	}

	public void controlSubMenuEmpleados() {
		logger.info("Entrada en el sub menú de empleados");
		int opcion = 0;
		do {
			mostrarSubMenu();
			opcion = leerInt();
			switch (opcion) {
			case CONSULTAR:
				mostrarListaEmpleados();
				break;
			case CONSULTAR_POR_ID:
				mostrarEmpleadoSegunId();
				break;
			case INSERTAR:
				break;
			case MODIFICAR:
				break;
			case BORRAR:
				break;
			case VOLVER:
				break;
			default:
				System.err.println("Opción no válida");
				logger.error("Se ha introducido una opción no válida");
			}
		} while (opcion != VOLVER);
	}

	public void controlSubMenuDepartamentos() {
		logger.info("Entrada en el sub menú de departamentos");
		int opcion = 0;
		do {
			mostrarSubMenu();
			opcion = leerInt();
			switch (opcion) {
			case CONSULTAR:
				mostrarListaDepartamentos();
				break;
			case CONSULTAR_POR_ID:
				mostrarDepartamentoSegunId();
				break;
			case INSERTAR:
				break;
			case MODIFICAR:
				break;
			case BORRAR:
				break;
			case VOLVER:
				break;
			default:
				logger.error("Se ha introducido una opción no válida");
				System.err.println("Opción no válida");
			}
		} while (opcion != VOLVER);
	}
	
	private void mostrarEmpleadoSegunId() {
		Empleado empleado = null;
		System.out.println("ID Empleado: ");
		int idEmpleado = leerInt();
		empleado = consultar.obtenerEmpleado(idEmpleado);
		System.out.println(empleado);
		logger.info("Empleado mostrado según el ID: "+idEmpleado);
	}
	
	private void mostrarDepartamentoSegunId() {
		Departamento departamento = null;
		System.out.println("ID Departamento: ");
		int idDepartamento = leerInt();
		departamento = consultar.obtenerDepartamento(idDepartamento);
		System.out.println(departamento);
		logger.info("Empleado mostrado según el ID: "+idDepartamento);
	}

	private void mostrarListaEmpleados() {
		logger.info("Mostrar listado de empleados");
		List<Empleado> empleados = consultar.listarEmpleados();
		for (Empleado e : empleados) {
			System.out.println(e);
		}
	}
	
	private void mostrarListaDepartamentos() {
		logger.info("Mostrar listado de departamentos");
		List<Departamento> departamentos = consultar.listarDepartamentos();
		for (Departamento d : departamentos) {
			System.out.println(d);
		}
	}

	public int leerInt() {
		logger.info("Lectura de un número entero por teclado");
		try {
			String numCad = sc.nextLine();
			int num = Integer.parseInt(numCad);
			logger.info("Número leído exitosamente");
			return num;
		} catch (NumberFormatException nfe) {
			System.err.println("Debes de introducir un valor entero");
			logger.error("Error de formato numérico");
		}
		return -1;
	}
}
