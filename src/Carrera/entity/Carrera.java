package Carrera.entity;

public class Carrera {

	private int cod_Carrera;
	private String Nombre;

	public Carrera(int cod_Carrera, String nombre) {
		super();
		this.cod_Carrera = cod_Carrera;
		Nombre = nombre;
	}

	public int getCod_Carrera() {
		return cod_Carrera;
	}

	public void setCod_Carrera(int cod_Carrera) {
		this.cod_Carrera = cod_Carrera;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Carrera [cod_Carrera=" + cod_Carrera + ", Nombre=" + Nombre + "]";
	}

}
