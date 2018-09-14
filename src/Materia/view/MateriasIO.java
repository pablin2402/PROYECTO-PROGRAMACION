package Materia.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;

public class MateriasIO {
	private Conexion conexion;
	private Scanner scanner;

	public MateriasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta(" SELECT m.cod_Materia, m.Nombre, m.Fecha_Inicio, m.Fecha_Final, m.Horario, m.Créditos\r\n"
				+ "FROM materia m");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DE LAS MATERIAS EN LA UNIVERSIDAD");
			System.out.println("");
			System.out.println("Código de la materia: " + resultSet.getInt("m.cod_Materia"));
			System.out.println("Nombre de la materia: " + resultSet.getString("m.Nombre"));
			System.out.println("Fecha de Inicio: " + resultSet.getDate("m.Fecha_Inicio"));
			System.out.println("Fecha de Finalización: " + resultSet.getDate("m.Fecha_Final"));
			System.out.println("Horario: " + resultSet.getString("m.Horario"));
			System.out.println("Número de Créditos: " + resultSet.getInt("m.Créditos"));
			System.out.println("---------------------------------------------------------");
		}

	}

}
