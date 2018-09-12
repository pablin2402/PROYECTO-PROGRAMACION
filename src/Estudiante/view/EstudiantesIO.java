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

	/****************************
	 * Constructor
	 * 
	 * @param productos *
	 ****************************/

	/****************************
	 * Agregar estudiantes *
	 ****************************/

	public EstudiantesIO(Conexion conexión, Scanner scanner2) {
		// TODO Auto-generated constructor stub
	}

	/****************************
	 * Modificar alumno
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante *
	 ****************************/
	public void update() throws SQLException, NoExisteEstudiante {

		ResultSet resultSet;

		Estudiante estudiante;

		int cod_Estudiante;
		int cod_Carrera;
		String nombre;
		String direccion;
		String correoelectronico;

		int cod_Estudiantes = InputTypes.readInt("Código de categoría: ", scanner);

		String sql = "select * from estudiante where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Estudiantes);

		resultSet = conexion.resultado();

		if (resultSet.next()) {
			cod_Estudiante = resultSet.getInt("cod_Estudiante");
			cod_Carrera = resultSet.getInt("cod_Carrera");
			nombre = resultSet.getString("Nombre");
			direccion = resultSet.getString("Ingrese la direcciòn");
			correoelectronico = resultSet.getString("correo");

			estudiante = new Estudiante(cod_Estudiante, cod_Carrera, nombre, direccion, correoelectronico);
		} else {
			throw new NoExisteEstudiante();
		}

		System.out.println(estudiante);
		Menu.menúModificar(scanner, estudiante);

		sql = "update estudiante set nombre = ?, descripción = ? where código = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setString(1, estudiante.getNombre());
		conexion.getSentencia().setInt(2, estudiante.getCod_Carrera());
		conexion.getSentencia().setString(3, estudiante.getDirección());
		conexion.modificacion();
	}

}
