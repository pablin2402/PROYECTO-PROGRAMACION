package Aula.entity;

public class Aula {
	private int cod_Aula;
	private int cod_edificio;
	private String Nombre;
	private int piso;
	public Aula(int cod_Aula, int cod_edificio, String nombre, int piso) {
		super();
		this.cod_Aula = cod_Aula;
		this.cod_edificio = cod_edificio;
		Nombre = nombre;
		this.piso = piso;
	}
	public int getCod_Aula() {
		return cod_Aula;
	}
	public void setCod_Aula(int cod_Aula) {
		this.cod_Aula = cod_Aula;
	}
	public int getCod_edificio() {
		return cod_edificio;
	}
	public void setCod_edificio(int cod_edificio) {
		this.cod_edificio = cod_edificio;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	@Override
	public String toString() {
		return "Aula [cod_Aula=" + cod_Aula + ", cod_edificio=" + cod_edificio + ", Nombre=" + Nombre + ", piso=" + piso
				+ "]";
	}



}
