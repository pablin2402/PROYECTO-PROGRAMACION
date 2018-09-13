package Carrera.entity;

public class NoExisteCarrera extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteCarrera() {
		super("No existe la carrera");
	}
}