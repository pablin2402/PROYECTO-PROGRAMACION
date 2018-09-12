package Estudiante.consultas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;

public class Consulta {

	public static void main(String[] args) {

	}

	public Consulta(Conexion conexion, Scanner scanner) {
	}

	public void con() {

		ResultSet resultSet;

		try {
			Conexion conexion = new Conexion("root", "", "universidad_oficial");

			conexion.consulta("  SELECT E.cod_Estudiante,C.Nombre,e.Nombre,e.Direcci�n,e.Correo_electr�nico\r\n"
					+ "  FROM estudiante e INNER JOIN carrera c ON e.cod_Carrera = c.cod_Carreras\r\n"
					+ "  GROUP BY e.cod_Estudiante ASC \r\n" + "");
			resultSet = conexion.resultado();

			while (resultSet.next()) {

				System.out.println("");

				System.out.println("C�DIGO ESTUDIANTE: " + (resultSet.getInt("cod_Estudiante")));

				System.out.println("CARRERA: " + (resultSet.getString("c.Nombre")));

				System.out.println("NOMBRE: " + (resultSet.getString("e.Nombre")));
				System.out.println("DIRECCI�N:" + (resultSet.getString("Direcci�n")));
				System.out.println("CORREO ELECTR�NICO:" + (resultSet.getString("Correo_electr�nico")));
				System.out.println("-------------------------------------------------");

			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
