package Clase.entity;

public class NoExisteClase extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteClase() {
		super("No existe la estudiante");
	}
}