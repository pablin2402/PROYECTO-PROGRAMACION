package Docente.entity;

import java.util.Date;

public class Docente {

	private int cod_Docente;
	private Date fecha_entrada;
	private String nombre;
	private Date fecha_nacimiento;
	private String Carrera;
	private int CI;

	public Docente(int cod_Docente, Date fecha_entrada, String nombre, Date fecha_nacimiento, String carrera, int cI) {
		super();
		this.cod_Docente = cod_Docente;

		this.fecha_entrada = fecha_entrada;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.Carrera = carrera;
		this.CI = cI;
	}

	public int getCod_Docente() {
		return cod_Docente;
	}

	public void setCod_Docente(int cod_Docente) {
		this.cod_Docente = cod_Docente;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}

	public int getCI() {
		return CI;
	}

	public void setCI(int cI) {
		CI = cI;
	}

	@Override
	public String toString() {
		return "Docente [cod_Docente=" + cod_Docente + ", fecha_entrada=" + fecha_entrada + ", nombre=" + nombre
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", Carrera=" + Carrera + ", CI=" + CI + "]";
	}

}
