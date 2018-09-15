package Clase.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Clase.entity.Clase;
import Clase.entity.NoExisteClase;
import Conexion.Conexion;
import VIEW.InputTypes;

public class ClasesIO {
	private Conexion conexion;
	private Scanner scanner;

	public ClasesIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta("SELECT m.Nombre,d.Nombre, e.Nombre,a.Nombre\r\n"
				+ "  FROM materia m INNER JOIN clase c ON m.cod_Materia = c.cod_Materia \r\n"
				+ "  INNER JOIN docentes d ON c.cod_Docente = d.cod_Docente \r\n"
				+ "  INNER JOIN estudiante e ON c.cod_Estudiante = e.cod_Estudiante\r\n"
				+ "  INNER JOIN aula a ON c.cod_Aula = a.cod_Aula");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DE LOS INSCRITOS LA UNIVERSIDAD");
			System.out.println("");
			System.out.println("Nombre de la Materia : " + resultSet.getString("m.Nombre"));
			System.out.println("Nombre del Docente: " + resultSet.getString("d.Nombre"));
			System.out.println("Nombre del Estudiante Inscrito: " + resultSet.getString("e.Nombre"));
			System.out.println("Nombre del Aula: " + resultSet.getString("a.Nombre"));

			System.out.println("---------------------------------------------------------");
		}

	}

	public void upload() throws SQLException, NoExisteClase {

		ResultSet resultSet;

		Clase clase;
		int cod_Materia;
		int cod_Docente;
		int cod_Estudiante = 0;
		int cod_Aula;

		int cod_Inscripci�n = InputTypes.readInt("C�digo de la inscripci�n: ", scanner);

		String sql = "SELECT* FROM clase  WHERE cod_Inscripci�n =?";
		System.out.println("Referencia de los datos de la inscripci�n de la materia antes de ser modificadas");
		System.out.println("Esto ser�a solo para administrador, no para usuario");
		System.out.println("------------------------------------------");

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Inscripci�n);
		resultSet = conexion.resultado();

		if (resultSet.next()) {
			cod_Materia = resultSet.getInt("cod_Materia");
			cod_Docente = resultSet.getInt("cod_Docente");
			cod_Aula = resultSet.getInt("cod_Aula");

			clase = new Clase(cod_Materia, cod_Docente, cod_Estudiante, cod_Aula, cod_Inscripci�n);

		} else {
			throw new NoExisteClase();
		}

		System.out.println(clase);
		Men�.men�Modificar(scanner, clase);
		/***
		 * Actualizar estudiante
		 */
		sql = "UPDATE clase c " + " SET c.cod_Materia=?," + " c.cod_Docente= ?," + "c.cod_Aula=?"
				+ " WHERE c.cod_Inscripci�n LIKE ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, clase.getCod_Materia());
		conexion.getSentencia().setInt(2, clase.getCod_Docente());
		conexion.getSentencia().setInt(3, clase.getCod_Aula());
		conexion.getSentencia().setInt(4, clase.getCod_Inscripci�n());
		conexion.modificacion();
	}

	/*******
	 * A�ADIR CLASE Excepcion todos
	 */
	public void add() {

		Clase estudiante = ClaseIO.ingresar(scanner);
		String sql = "INSERT INTO clase (cod_Materia,cod_Docente,cod_Estudiante,cod_Aula,cod_Inscripci�n) "
				+ "values(?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Materia());
			conexion.getSentencia().setInt(2, estudiante.getCod_Docente());
			conexion.getSentencia().setInt(3, estudiante.getCod_Estudiante());
			conexion.getSentencia().setInt(4, estudiante.getCod_Aula());
			conexion.getSentencia().setInt(5, estudiante.getCod_Inscripci�n());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
}
