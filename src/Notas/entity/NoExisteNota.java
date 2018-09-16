package Notas.entity;

public class NoExisteNota extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteNota(String string) {
		super("No existe el código de nota");
	}

}
