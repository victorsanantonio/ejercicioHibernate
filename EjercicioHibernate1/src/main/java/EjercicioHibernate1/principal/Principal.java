package EjercicioHibernate1.principal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import EjercicioHibernate1.controlador.Consultar;


public class Principal {
	private static Logger logger = LogManager.getLogger(Principal.class);
	
	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String url = "C:\\Users\\Formacion\\Desktop\\HibernateEjercicio1\\EjercicioHibernate1\\src\\main\\java\\log4j.properties";
		System.out.println(url);
		PropertyConfigurator.configure(url);
		
		Consultar consultar = new Consultar();
		System.out.println(consultar.obtenerEmpleado(1));
	}
}
