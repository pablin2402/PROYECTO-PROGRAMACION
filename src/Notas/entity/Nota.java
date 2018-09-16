package Notas.entity;

public class Nota {
	private int cod_Nota;
	private int cod_Docente;
	private int cod_Estudiante;
	private int cod_Materia;
	private int nota;

	public Nota(int cod_Nota, int cod_Docente, int cod_Estudiante, int cod_Materia, int nota) {
		super();
		this.cod_Nota = cod_Nota;
		this.cod_Docente = cod_Docente;
		this.cod_Estudiante = cod_Estudiante;
		this.cod_Materia = cod_Materia;
		this.nota = nota;
	}

	public int getCod_Nota() {
		return cod_Nota;
	}

	public void setCod_Nota(int cod_Nota) {
		this.cod_Nota = cod_Nota;
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

	public int getCod_Materia() {
		return cod_Materia;
	}

	public void setCod_Materia(int cod_Materia) {
		this.cod_Materia = cod_Materia;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Notas [cod_Nota=" + cod_Nota + ", cod_Docente=" + cod_Docente + ", cod_Estudiante=" + cod_Estudiante
				+ ", cod_Materia=" + cod_Materia + ", nota=" + nota + "]";
	}

}
