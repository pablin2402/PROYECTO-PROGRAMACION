package Docente.entity;

public class NoExisteDocente extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteDocente() {
		super("No existe el docente");
	}
}
