package Clase.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;

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

}
