package Estudiante.entity;

public class NoExisteEstudiante extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteEstudiante() {
		super("No existe el estudiante");
	}

}
