package Estudiante.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Carrera.entity.Carrera;
import Carrera.entity.NoExisteCarrera;
import Conexion.Conexion;
import Estudiante.entity.Estudiante;
import Estudiante.entity.NoExisteEstudiante;
import Notas.entity.NoExisteNota;
import Notas.entity.Nota;
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
				" SELECT e.cod_Carrera,e.cod_Estudiante,e.Nombre,e.Dirección,e.Correo_electrónico FROM estudiante e");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DEL ESTUDIANTE");
			System.out.println("");
			System.out.println("Código de la carrera: " + resultSet.getInt("e.cod_Carrera"));
			System.out.println("Código Estudiante: " + resultSet.getInt("e.cod_Estudiante"));
			System.out.println("Nombre: " + resultSet.getString("e.Nombre"));
			System.out.println("Dirección: " + resultSet.getString("e.Dirección"));
			System.out.println("Correo Electrónico: " + resultSet.getString("e.Correo_electrónico"));
			System.out.println("---------------------------------------------------------");
		}

	}

	/****
	 * Modifica
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 */
	public void upload() throws NoExisteEstudiante, SQLException {

		ResultSet resultSet;

		Estudiante estudiante;
		int cod_Carrera;
		String nombre = null;
		String dirección;
		String correoelectrónico;

		int cod_Estudiante = InputTypes.readInt("Código del estudiante: ", scanner);

		String sql = "SELECT* FROM estudiante  WHERE cod_Estudiante =?";
		System.out.println("Referencia de los datos del estudiantes antes de que se modifiquen");
		System.out.println("------------------------------------------");

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Estudiante);
		resultSet = conexion.resultado();

		if (resultSet.next()) {
			cod_Carrera = resultSet.getInt("cod_Carrera");
			nombre = resultSet.getString("Nombre");
			dirección = resultSet.getString("Dirección");
			correoelectrónico = resultSet.getString("Correo_electrónico");

			estudiante = new Estudiante(cod_Estudiante, cod_Carrera, nombre, dirección, correoelectrónico);

		} else {
			throw new NoExisteEstudiante();
		}

		System.out.println(estudiante);
		Menu.menúModificar(scanner, estudiante);
		/***
		 * Actualizar estudiante
		 */
		sql = "UPDATE estudiante e SET e.cod_Carrera, e.Nombre, e.Dirección, e.Correo_electrónico WHERE e.cod_Estudiante LIKE ";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, estudiante.getCod_Carrera());
		conexion.getSentencia().setString(2, estudiante.getDirección());
		conexion.getSentencia().setString(3, estudiante.getCorreoelectrónico());
		conexion.getSentencia().setInt(4, estudiante.getCod_Estudiante());
		conexion.modificacion();
	}

	/********
	 * Añadir un nuevo estudiante excepcion de buscar
	 */
	public void add() {
		Estudiante estudiante = EstudianteIO.ingresar(scanner);
		String sql = "INSERT INTO estudiante ( cod_Estudiante,cod_Carrera, Nombre, Dirección, Correo_electrónico) "
				+ "values(?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Estudiante());
			conexion.getSentencia().setInt(2, estudiante.getCod_Carrera());
			conexion.getSentencia().setString(3, estudiante.getNombre());
			conexion.getSentencia().setString(4, estudiante.getDirección());
			conexion.getSentencia().setString(5, estudiante.getCorreoelectrónico());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void listaalumnosporcarrera() throws SQLException, NoExisteEstudiante, NoExisteCarrera {
		ResultSet resultSet;
		Estudiante estudiante;
		int cod_Carrera;
		String nombre;
		String dirección;
		String correoelectrónico;
		int cod_Estudiante = InputTypes.readInt("Código de estudiante: ", scanner);
		String sql = "select * from estudiante where cod_Estudiante = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Estudiante);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			cod_Carrera = resultSet.getInt("cod_Carrera");
			nombre = resultSet.getString("Nombre");
			dirección = resultSet.getString("Dirección");
			correoelectrónico = resultSet.getString("Correo_electrónico");

			estudiante = new Estudiante(cod_Estudiante, cod_Carrera, nombre, dirección, correoelectrónico);
		} else {
			throw new NoExisteEstudiante();
		}
		System.out.println(estudiante);

		Carrera carrera;

		sql = "select * from carrera where cod_Carreras = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Carrera);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("Nombre");
			carrera = new Carrera(cod_Carrera, nombre);
			System.out.println(carrera);
		} else {
			throw new NoExisteCarrera();
		}

	}

	public void consultarnotas() throws SQLException, NoExisteEstudiante, NoExisteNota {

		ResultSet resultSet;
		Estudiante estudiante;
		int cod_Carrera;
		String nombre;
		String dirección;
		String correoelectrónico;
		int cod_Estudiante = InputTypes.readInt("Código de estudiante: ", scanner);
		String sql = "select * from estudiante where cod_Estudiante = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Estudiante);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			cod_Carrera = resultSet.getInt("cod_Carrera");
			nombre = resultSet.getString("Nombre");
			dirección = resultSet.getString("Dirección");
			correoelectrónico = resultSet.getString("Correo_electrónico");

			estudiante = new Estudiante(cod_Estudiante, cod_Carrera, nombre, dirección, correoelectrónico);
		} else {
			throw new NoExisteEstudiante();
		}
		System.out.println(estudiante);

		Nota carrera;

		sql = "select * from notas where cod_Estudiante= ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Estudiante);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			int cod_Nota = resultSet.getInt("cod_Nota");
			int cod_Docente = resultSet.getInt("cod_Docente");
			cod_Estudiante = resultSet.getInt("cod_Estudiante");
			int cod_Materia = resultSet.getInt("cod_Materia");
			int nota = resultSet.getInt("nota");

			carrera = new Nota(cod_Nota, cod_Docente, cod_Estudiante, cod_Materia, nota);

			System.out.println(carrera);
		} else {
			throw new NoExisteNota();
		}

	}

}