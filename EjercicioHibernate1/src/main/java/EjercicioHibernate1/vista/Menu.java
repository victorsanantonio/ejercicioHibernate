package EjercicioHibernate1.vista;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import EjercicioHibernate1.controlador.Borrar;
import EjercicioHibernate1.controlador.Consultar;
import EjercicioHibernate1.controlador.Insertar;
import EjercicioHibernate1.controlador.Modificar;
import EjercicioHibernate1.modelo.Departamento;
import EjercicioHibernate1.modelo.Empleado;
import EjercicioHibernate1.principal.Principal;

public class Menu {
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
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

	Consultar consultar = new Consultar();
	Insertar insertar = new Insertar();
	Modificar modificar = new Modificar();
	Borrar borrar = new Borrar();

	public void mostrarMenu() {
		System.out.println("\t--GESTIONAR-->");
		System.out.println(EMPLEADOS + ". Empleados");
		System.out.println(DEPARTAMENTOS + ". Departamentos");
		System.out.println(SALIR + ". Salir");
	}

	public void mostrarSubMenu() {
		System.out.println(CONSULTAR + ". Consultar todos los registros");
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

	private void controlSubMenuEmpleados() {
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
				insertarEmpleado();
				break;
			case MODIFICAR:
				modificarEmpleado();
				break;
			case BORRAR:
				borrarEmpleado();
				break;
			case VOLVER:
				break;
			default:
				System.err.println("Opción no válida");
				logger.error("Se ha introducido una opción no válida");
			}
		} while (opcion != VOLVER);
	}

	private void controlSubMenuDepartamentos() {
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
				insertarDepartamento();
				break;
			case MODIFICAR:
				modificarDepartamento();
				break;
			case BORRAR:
				borrarDepartamento();
				break;
			case VOLVER:
				break;
			default:
				logger.error("Se ha introducido una opción no válida");
				System.err.println("Opción no válida");
			}
		} while (opcion != VOLVER);
	}
	
	private void modificarEmpleado() {
		System.out.print("Código del empleado:\t");
		int codigoActual = leerInt();
		
		System.out.print("Código nuevo:\t");
		int codigoNuevo = leerInt();
		System.out.print("Nombre:\t");
		String nombre = sc.nextLine();
		System.out.print("Apellido 1:\t");
		String apellido1 = sc.nextLine();
		System.out.print("Apellido 2:\t");
		String apellido2 = sc.nextLine();
		System.out.print("Lugar nacimiento:\t");
		String lugarNacimiento = sc.nextLine();
		System.out.print("Fecha nacimiento:\t");
		String fechaNacimiento = sc.nextLine();
		System.out.print("Dirección:\t");
		String direccion = sc.nextLine();
		System.out.print("Teléfono:\t");
		String telefono = sc.nextLine();
		System.out.print("Puesto:\t");
		String puesto = sc.nextLine();
		System.out.println("Código departamento:\t");
		int codDepartamento = leerInt();

		modificar.actualizarEmpleado(codigoActual, codigoNuevo, nombre, apellido1, apellido2, lugarNacimiento, fechaNacimiento, direccion, telefono, puesto, codDepartamento, sessionFactory);
		
		logger.info("Empleado "+nombre+" actualizado correctamente");
	}
	
	private void modificarDepartamento() {
		System.out.print("Código del departamento:\t");
		int codigoActual = leerInt();
		
		System.out.print("Código nuevo:\t");
		int codigoNuevo = leerInt();
		System.out.print("Nombre:\t");
		String nombre = sc.nextLine();
		System.out.println("Código responsable:\t");
		int codResponsable = leerInt();

		modificar.actualizarDepartamento(codigoActual, codigoNuevo, nombre, codResponsable, sessionFactory);
		
		logger.info("Departamento "+nombre+" actualizado correctamente");
	}
	
	private void borrarEmpleado() {
		System.out.print("Código:\t");
		int codigo = leerInt();
		Empleado empleado = consultar.obtenerEmpleado(codigo);
		borrar.borrarEmpleado(empleado);
		logger.info("Empleado "+empleado+" borrado correctamente");
	}
	
	private void borrarDepartamento() {
		System.out.print("Código:\t");
		int codigo = leerInt();
		Departamento departamento = consultar.obtenerDepartamento(codigo);
		borrar.borrarDepartamento(departamento);
		logger.info("Departamento "+departamento+" borrado correctamente");
	}

	private void insertarDepartamento() {
		System.out.print("Código:\t");
		int codigo = leerInt();
		System.out.print("Nombre:\t");
		String nombre = sc.nextLine();
		System.out.print("Código responsable:\t");
		int codResponsable = leerInt();
		Departamento departamento = new Departamento(codigo, nombre, codResponsable);
		insertar.guardarDepartamento(departamento);
		logger.info("Departamento " + codigo + " insertado correctamente");
	}

	private void insertarEmpleado() {
		System.out.print("Código:\t");
		int codigo = leerInt();
		System.out.print("Nombre:\t");
		String nombre = sc.nextLine();
		System.out.print("Apellido 1:\t");
		String apellido1 = sc.nextLine();
		System.out.print("Apellido 2:\t");
		String apellido2 = sc.nextLine();
		System.out.print("Lugar nacimiento:\t");
		String lugarNacimiento = sc.nextLine();
		System.out.print("Fecha nacimiento:\t");
		String fechaNacimiento = sc.nextLine();
		System.out.print("Dirección:\t");
		String direccion = sc.nextLine();
		System.out.print("Teléfono:\t");
		String telefono = sc.nextLine();
		System.out.print("Puesto:\t");
		String puesto = sc.nextLine();
		System.out.println("Código departamento:\t");
		int codDepartamento = leerInt();

		Empleado empleado = new Empleado(codigo, nombre, apellido1, apellido2, lugarNacimiento, fechaNacimiento,
				direccion, telefono, puesto, codDepartamento);
		insertar.guardarEmpleado(empleado);
		logger.info("Empleado " + codigo + " insertado correctamente");
	}

	private void mostrarEmpleadoSegunId() {
		Empleado empleado = null;
		System.out.println("ID Empleado: ");
		int idEmpleado = leerInt();
		empleado = consultar.obtenerEmpleado(idEmpleado);
		System.out.println(empleado);
		logger.info("Empleado mostrado según el ID: " + idEmpleado);
	}

	private void mostrarDepartamentoSegunId() {
		Departamento departamento = null;
		System.out.println("ID Departamento: ");
		int idDepartamento = leerInt();
		departamento = consultar.obtenerDepartamento(idDepartamento);
		System.out.println(departamento);
		logger.info("Empleado mostrado según el ID: " + idDepartamento);
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
