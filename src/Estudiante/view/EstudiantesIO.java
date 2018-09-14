package Estudiante.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;

public class EstudiantesIO {

	private Conexion conexion;
	private Scanner scanner;

	public EstudiantesIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

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

}
