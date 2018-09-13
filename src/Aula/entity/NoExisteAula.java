package Aula.entity;

public class NoExisteAula extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteAula() {
		super("No existe el aula");
	}
}