package Conexion;

public class Sentencia {
/**
 * 
 */
	public static String REGISTRAR = "INSERT INTO estudiante (" + "cod_carrera," + "nombre =?," + "direcci�n =?,"
			+ "Correoelectr�nico =?)" + "VALUES";

	public static String UPDATE = ("UPDATE ESTUDIANTE SET" + "cod_carrera = ?," + " Direccion=? " + "correoelectr�nico"
			+ " WHERE ESTUDIANTE LIKE =? ");
	public static String ELIMINAR = ("DELETE FROM estudiante WHERE cod_estudiante LIKE =?");

	private int cod_carrera;
	private String nombre;
	private String Direcci�n;
	private String correolectr�nico;
/**
 * Setters y getters 
 * @return
 */
	public int getCod_carrera() {
		return cod_carrera;
	}

	public void setCod_carrera(int cod_carrera) {
		this.cod_carrera = cod_carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirecci�n() {
		return Direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		Direcci�n = direcci�n;
	}

	public String getCorreolectr�nico() {
		return correolectr�nico;
	}

	public void setCorreolectr�nico(String correolectr�nico) {
		this.correolectr�nico = correolectr�nico;
	}

}