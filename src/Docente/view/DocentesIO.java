package Docente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;

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
			System.out.println("Fecha de Entrada: " + resultSet.getDate("d.fecha_entrada"));
			System.out.println("Nombre: " + resultSet.getString("d.Nombre"));
			System.out.println("Fecha de Nacimiente: " + resultSet.getDate("d.fecha_nacimiento"));
			System.out.println("Carrera: " + resultSet.getString("d.Carrera"));

			System.out.println("---------------------------------------------------------");
		}
	}
}