package Clase.entity;

public class Clase {

	private int cod_Materia;
	private int cod_Docente;
	private int cod_Estudiante;
	private int cod_Aula;
	private int cod_Inscripci�n;

	public Clase(int cod_Materia, int cod_Docente, int cod_Estudiante, int cod_Aula, int cod_Inscripci�n) {
		super();
		this.cod_Materia = cod_Materia;
		this.cod_Docente = cod_Docente;
		this.cod_Estudiante = cod_Estudiante;
		this.cod_Aula = cod_Aula;
		this.cod_Inscripci�n = cod_Inscripci�n;
	}

	public int getCod_Materia() {
		return cod_Materia;
	}

	public void setCod_Materia(int cod_Materia) {
		this.cod_Materia = cod_Materia;
	}

	public int getCod_Docente() {
		return cod_Docente;
	}

	public void setCod_Docente(int cod_Docente) {
		this.cod_Docente = cod_Docente;
	}

	public int getCod_Estudiante() {
		return cod_Estudiante;
	}

	public void setCod_Estudiante(int cod_Estudiante) {
		this.cod_Estudiante = cod_Estudiante;
	}

	public int getCod_Aula() {
		return cod_Aula;
	}

	public void setCod_Aula(int cod_Aula) {
		this.cod_Aula = cod_Aula;
	}

	public int getCod_Inscripci�n() {
		return cod_Inscripci�n;
	}

	public void setCod_Inscripci�n(int cod_Inscripci�n) {
		this.cod_Inscripci�n = cod_Inscripci�n;
	}

	@Override
	public String toString() {
		return "Clase [cod_Materia=" + cod_Materia + ", cod_Docente=" + cod_Docente + ", cod_Estudiante="
				+ cod_Estudiante + ", cod_Aula=" + cod_Aula + ", cod_Inscripci�n=" + cod_Inscripci�n + "]";
	}

}
