package Estudiante.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;
import Estudiante.entity.Estudiante;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class EstudiantesIO {

	private Conexion conexion;
	private Scanner scanner;

	public EstudiantesIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	/***
	 * Muestra todos los registros
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta(
				" SELECT e.cod_Carrera,e.cod_Estudiante,e.Nombre,e.Direcci�n,e.Correo_electr�nico FROM estudiante e");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DEL ESTUDIANTE");
			System.out.println("");
			System.out.println("C�digo de la carrera: " + resultSet.getInt("e.cod_Carrera"));
			System.out.println("C�digo Estudiante: " + resultSet.getInt("e.cod_Estudiante"));
			System.out.println("Nombre: " + resultSet.getString("e.Nombre"));
			System.out.println("Direcci�n: " + resultSet.getString("e.Direcci�n"));
			System.out.println("Correo Electr�nico: " + resultSet.getString("e.Correo_electr�nico"));
			System.out.println("---------------------------------------------------------");
		}

	}

	/****
	 * Modifica
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 */
	public void upload() throws SQLException, NoExisteEstudiante {

		ResultSet resultSet;

		Estudiante estudiante;
		int cod_Carrera;
		String nombre = null;
		String direcci�n;
		String correoelectr�nico;

		int cod_Estudiante = InputTypes.readInt("C�digo del estudiante: ", scanner);

		String sql = "SELECT* FROM estudiante  WHERE cod_Estudiante =?";
		System.out.println("Referencia de los datos del estudiantes antes de que se modifiquen");
		System.out.println("------------------------------------------");

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Estudiante);
		resultSet = conexion.resultado();

		if (resultSet.next()) {
			cod_Carrera = resultSet.getInt("cod_Carrera");
			direcci�n = resultSet.getString("Direcci�n");
			correoelectr�nico = resultSet.getString("Correo_electr�nico");

			estudiante = new Estudiante(cod_Estudiante, cod_Carrera, nombre, direcci�n, correoelectr�nico);

		} else {
			throw new NoExisteEstudiante();
		}

		System.out.println(estudiante);
		Menu.men�Modificar(scanner, estudiante);
		/***
		 * Actualizar estudiante
		 */
		sql = "UPDATE estudiante e SET e.cod_Carrera, e.Nombre, e.Direcci�n, e.Correo_electr�nico WHERE e.cod_Estudiante LIKE ";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, estudiante.getCod_Carrera());
		conexion.getSentencia().setString(2, estudiante.getDirecci�n());
		conexion.getSentencia().setString(3, estudiante.getCorreoelectr�nico());
		conexion.getSentencia().setInt(4, estudiante.getCod_Estudiante());
		conexion.modificacion();
	}

	/********
	 * A�adir un nuevo estudiante excepcion de buscar
	 */
	public void add() {
		Estudiante estudiante = EstudianteIO.ingresar(scanner);
		String sql = "INSERT INTO estudiante ( cod_Estudiante,cod_Carrera, Nombre, Direcci�n, Correo_electr�nico) "
				+ "values(?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Estudiante());
			conexion.getSentencia().setInt(2, estudiante.getCod_Carrera());
			conexion.getSentencia().setString(3, estudiante.getNombre());
			conexion.getSentencia().setString(4, estudiante.getDirecci�n());
			conexion.getSentencia().setString(5, estudiante.getCorreoelectr�nico());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
}
