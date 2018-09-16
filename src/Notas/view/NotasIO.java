package Notas.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Clase.entity.NoExisteClase;
import Conexion.Conexion;
import Notas.entity.NoExisteNota;
import Notas.entity.Nota;
import VIEW.InputTypes;

public class NotasIO {
	private Conexion conexion;
	private Scanner scanner;

	public NotasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta(
				" SELECT n.cod_Nota,n.cod_Docente,n.cod_Estudiante,n.cod_Materia,n.nota\r\n" + "FROM notas n");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DE LA NOTA");
			System.out.println("");
			System.out.println("Código de Registro de Nota: " + resultSet.getInt("n.cod_Nota"));
			System.out.println("Código del docente: " + resultSet.getString("n.cod_Docente"));
			System.out.println("Código del estudiante: " + resultSet.getString("n.cod_Estudiante"));
			System.out.println("Código de la materia: " + resultSet.getString("n.cod_Materia"));
			System.out.println("NOTA: " + resultSet.getInt("n.nota"));

			System.out.println("---------------------------------------------------------");
		}
	}

	/*************
	 * 
	 */
	public void add() {

		Nota estudiante = NotaIO.ingresar(scanner);
		String sql = "INSERT INTO notas (cod_Nota,cod_Docente,cod_Estudiante,cod_Materia,nota) " + "values(?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Nota());
			conexion.getSentencia().setInt(2, estudiante.getCod_Docente());
			conexion.getSentencia().setInt(3, estudiante.getCod_Estudiante());
			conexion.getSentencia().setInt(4, estudiante.getCod_Materia());
			conexion.getSentencia().setInt(5, estudiante.getNota());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/**********
	 * Cambiar nota de la materia
	 * 
	 * @throws SQLException
	 * @throws NoExisteNota
	 * @throws NoExisteClase
	 */
	public void upload() throws SQLException, NoExisteNota {

		ResultSet resultSet;

		Nota clase;
		int cod_Materia;
		int cod_Docente;
		int cod_Estudiante;
		int cod_Aula;
		int nota;

		int cod_Nota = InputTypes.readInt("Código único de cada nota: ", scanner);

		String sql = "SELECT* FROM notas  WHERE cod_Nota =?";
		System.out.println("Referencia de los datos ");
		System.out.println("Esto sería solo para administrador, no para usuario");
		System.out.println("------------------------------------------");

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Nota);
		resultSet = conexion.resultado();

		if (resultSet.next()) {
			cod_Nota = resultSet.getInt("cod_Nota");
			cod_Docente = resultSet.getInt("cod_Docente");
			cod_Estudiante = resultSet.getInt("cod_Estudiante");

			cod_Materia = resultSet.getInt("cod_Materia");
			nota = resultSet.getInt("nota");

			clase = new Nota(cod_Nota, cod_Docente, cod_Estudiante, cod_Materia, nota);

		} else {
			throw new NoExisteNota("");
		}

		System.out.println(clase);
		Menu.menúModificar(scanner, clase);
		/*******
		 * Consulta SQL
		 */
		sql = "UPDATE notas n SET n.nota=? WHERE n.cod_Nota LIKE ? ";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, clase.getNota());
		conexion.getSentencia().setInt(2, clase.getCod_Nota());

		conexion.modificacion();
	}

}
