package EjercicioHibernate1.modelo;

import java.io.Serializable;

public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private int codResponsable;
	public Departamento(int codigo, String nombre, int codResponsable) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.codResponsable = codResponsable;
	}
	public Departamento() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodResponsable() {
		return codResponsable;
	}
	public void setCodResponsable(int codResponsable) {
		this.codResponsable = codResponsable;
	}
	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", codResponsable=" + codResponsable + "]";
	}
}
