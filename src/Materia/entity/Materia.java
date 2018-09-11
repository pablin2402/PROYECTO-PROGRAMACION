package Materia.entity;

import java.util.Date;

public class Materia {
	private int cod_Materia;
	private String Nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String horarios;
	private int Creditos;
	private int total_a_pagar;

	public Materia(int cod_Materia, String nombre, Date fecha_inicio, Date fecha_fin, String horarios, int creditos,
			int total_a_pagar) {
		super();
		this.cod_Materia = cod_Materia;
		Nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.horarios = horarios;
		Creditos = creditos;
		this.total_a_pagar = total_a_pagar;
	}

	public int getCod_Materia() {
		return cod_Materia;
	}

	public void setCod_Materia(int cod_Materia) {
		this.cod_Materia = cod_Materia;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public int getCreditos() {
		return Creditos;
	}

	public void setCreditos(int creditos) {
		Creditos = creditos;
	}

	public int getTotal_a_pagar() {
		return total_a_pagar;
	}

	public void setTotal_a_pagar(int total_a_pagar) {
		this.total_a_pagar = total_a_pagar;
	}

	@Override
	public String toString() {
		return "Materia [cod_Materia=" + cod_Materia + ", Nombre=" + Nombre + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", horarios=" + horarios + ", Creditos=" + Creditos + ", total_a_pagar="
				+ total_a_pagar + "]";
	}

}
