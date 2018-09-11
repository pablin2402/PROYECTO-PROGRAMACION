package Estudiante.entity;

public class Estudiante {
	private int cod_Estudiante;
	private int cod_Carrera;
	private String Nombre;
	private String Dirección;
	private String correoelectrónico;

	public Estudiante(int cod_Estudiante, int cod_Carrera, String nombre, String dirección, String correoelectrónico) {
		super();
		this.cod_Estudiante = cod_Estudiante;
		this.cod_Carrera = cod_Carrera;
		Nombre = nombre;
		Dirección = dirección;
		this.correoelectrónico = correoelectrónico;
	}

	public int getCod_Estudiante() {
		return cod_Estudiante;
	}

	public void setCod_Estudiante(int cod_Estudiante) {
		this.cod_Estudiante = cod_Estudiante;
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

	public String getDirección() {
		return Dirección;
	}

	public void setDirección(String dirección) {
		Dirección = dirección;
	}

	public String getCorreoelectrónico() {
		return correoelectrónico;
	}

	public void setCorreoelectrónico(String correoelectrónico) {
		this.correoelectrónico = correoelectrónico;
	}

	@Override
	public String toString() {
		return "Estudiante [cod_Estudiante=" + cod_Estudiante + ", cod_Carrera=" + cod_Carrera + ", Nombre=" + Nombre
				+ ", Dirección=" + Dirección + ", correoelectrónico=" + correoelectrónico + "]";
	}

}
