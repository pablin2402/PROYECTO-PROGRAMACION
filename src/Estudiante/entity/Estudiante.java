package Estudiante.entity;

public class Estudiante {
	private int cod_Estudiante;
	private int cod_Carrera;
	private String Nombre;
	private String Direcci�n;
	private String correoelectr�nico;

	public Estudiante(int cod_Estudiante, int cod_Carrera, String nombre, String direcci�n, String correoelectr�nico) {
		super();
		this.cod_Estudiante = cod_Estudiante;
		this.cod_Carrera = cod_Carrera;
		Nombre = nombre;
		Direcci�n = direcci�n;
		this.correoelectr�nico = correoelectr�nico;
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

	public String getDirecci�n() {
		return Direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		Direcci�n = direcci�n;
	}

	public String getCorreoelectr�nico() {
		return correoelectr�nico;
	}

	public void setCorreoelectr�nico(String correoelectr�nico) {
		this.correoelectr�nico = correoelectr�nico;
	}

	@Override
	public String toString() {
		return "Estudiante [cod_Estudiante=" + cod_Estudiante + ", cod_Carrera=" + cod_Carrera + ", Nombre=" + Nombre
				+ ", Direcci�n=" + Direcci�n + ", correoelectr�nico=" + correoelectr�nico + "]";
	}

}
