package EjercicioHibernate1.vista;

import java.util.Scanner;

public class Menu {
	static final int EMPLEADOS = 1;
	static final int DEPARTAMENTOS = 2;
	static final int SALIR = 3;
	
	static final int CONSULTAR=1;
	static final int CONSULTAR_POR_ID=2;
	static final int INSERTAR=3;
	static final int MODIFICAR=4;
	static final int BORRAR=5;
	static final int VOLVER=6;

	static Scanner sc = new Scanner(System.in);

	public void mostrarMenu() {
		System.out.println("\t--GESTIONAR-->");
		System.out.println(EMPLEADOS + ". Empleados");
		System.out.println(DEPARTAMENTOS + ". Departamentos");
		System.out.println(SALIR + ". Salir");
	}
	
	public void mostrarSubMenu() {
		System.out.println(CONSULTAR + ". Consultar todos los empleados");
		System.out.println(CONSULTAR_POR_ID + ". Consultar por un ID");
		System.out.println(INSERTAR+". Insertar");
		System.out.println(MODIFICAR+". Modificar");
		System.out.println(BORRAR+". Borrar");
		System.out.println(VOLVER + ". Volver");
	}

	public void controlMenu() {
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
			}
		} while (opcion != SALIR);
	}
	
	public void controlSubMenuEmpleados() {
		int opcion = 0;
		do {
			mostrarSubMenu();
			opcion = leerInt();
			switch (opcion) {
			case CONSULTAR:
				break;
			case CONSULTAR_POR_ID:
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
			}
		} while (opcion != VOLVER);
	}
	
	public void controlSubMenuDepartamentos() {
		int opcion = 0;
		do {
			mostrarSubMenu();
			opcion = leerInt();
			switch (opcion) {
			case CONSULTAR:
				break;
			case CONSULTAR_POR_ID:
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
			}
		} while (opcion != VOLVER);
	}

	public int leerInt() {
		try {
			String numCad = sc.nextLine();
			int num = Integer.parseInt(numCad);
			return num;
		} catch (NumberFormatException nfe) {
			System.err.println("Debes de introducir un valor entero");
		}
		return -1;
	}
}
