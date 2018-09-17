package Materia.entity;

public class NoExisteMateria extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteMateria() {
		super("No existe la materia");
	}

}
