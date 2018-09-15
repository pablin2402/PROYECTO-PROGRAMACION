package Docente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;
import Docente.entity.Docente;

public class DocentesIO {
	private Conexion conexion;
	private Scanner scanner;

	public DocentesIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta(
				" SELECT d.cod_Docente,d.fecha_entrada,d.Nombre,d.fecha_nacimiento,d.Carrera\r\n" + "FROM docentes d");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DEL DOCENTE");
			System.out.println("");
			System.out.println("Código Docente: " + resultSet.getInt("d.cod_Docente"));
			System.out.println("Fecha de Entrada: " + resultSet.getString("d.fecha_entrada"));
			System.out.println("Nombre: " + resultSet.getString("d.Nombre"));
			System.out.println("Fecha de Nacimiente: " + resultSet.getString("d.fecha_nacimiento"));
			System.out.println("Carrera: " + resultSet.getString("d.Carrera"));

			System.out.println("---------------------------------------------------------");
		}
	}

	/****************
	 * AÑADIR DOCENTE
	 */
	public void add() {

		Docente estudiante = DocenteIO.ingresar(scanner);
		String sql = "INSERT INTO docentes (cod_Docente, fecha_entrada, Nombre, fecha_nacimiento, Carrera, `C.I`) "
				+ "values(?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Docente());
			conexion.getSentencia().setString(2, estudiante.getFecha_entrada());
			conexion.getSentencia().setString(3, estudiante.getNombre());
			conexion.getSentencia().setString(4, estudiante.getFecha_nacimiento());
			conexion.getSentencia().setString(5, estudiante.getCarrera());
			conexion.getSentencia().setInt(6, estudiante.getCI());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
}