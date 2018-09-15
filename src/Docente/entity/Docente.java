package Docente.entity;

public class Docente {

	private int cod_Docente;
	private String fecha_entrada;
	private String nombre;
	private String fecha_nacimiento;
	private String Carrera;
	private int CI;

	public Docente(int cod_Docente, String fecha_entrada, String nombre, String fecha_nacimiento, String carrera,
			int cI) {
		super();
		this.cod_Docente = cod_Docente;
		this.fecha_entrada = fecha_entrada;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		Carrera = carrera;
		CI = cI;
	}

	public int getCod_Docente() {
		return cod_Docente;
	}

	public void setCod_Docente(int cod_Docente) {
		this.cod_Docente = cod_Docente;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
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
