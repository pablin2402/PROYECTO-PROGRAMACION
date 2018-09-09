package Conexion;

public class Sentencia {
/**
 * 
 */
	public static String REGISTRAR = "INSERT INTO estudiante (" + "cod_carrera," + "nombre =?," + "dirección =?,"
			+ "Correoelectrònico =?)" + "VALUES";

	public static String UPDATE = ("UPDATE ESTUDIANTE SET" + "cod_carrera = ?," + " Direccion=? " + "correoelectrónico"
			+ " WHERE ESTUDIANTE LIKE =? ");
	public static String ELIMINAR = ("DELETE FROM estudiante WHERE cod_estudiante LIKE =?");

	private int cod_carrera;
	private String nombre;
	private String Dirección;
	private String correolectrónico;
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

	public String getDirección() {
		return Dirección;
	}

	public void setDirección(String dirección) {
		Dirección = dirección;
	}

	public String getCorreolectrónico() {
		return correolectrónico;
	}

	public void setCorreolectrónico(String correolectrónico) {
		this.correolectrónico = correolectrónico;
	}

}