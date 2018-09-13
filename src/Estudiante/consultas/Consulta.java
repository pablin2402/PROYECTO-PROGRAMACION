package Estudiante.consultas;

import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;
import Estudiante.entity.Estudiante;

public class Consulta {

	public void list() throws SQLException {

		Conexion conexion;
		conexion.consulta(sql);

		Estudiante categoría;
		String sql = " SELECT E.cod_Estudiante,C.Nombre,e.Nombre,e.Dirección,e.Correo_electrónico\\r\\n\"\r\n"
				+ "					+ \"  FROM estudiante e INNER JOIN carrera c ON e.cod_Carrera = c.cod_Carreras\\r\\n\"\r\n"
				+ "					+ \"  GROUP BY e.cod_Estudiante ASC \\r\\n\" + \"";

		ResultSet resultSet = null;

		while (resultSet.next()) {

			System.out.println("");

			System.out.println("CÓDIGO ESTUDIANTE: " + (resultSet.getInt("cod_Estudiante")));

			System.out.println("CARRERA: " + (resultSet.getString("c.Nombre")));

			System.out.println("NOMBRE: " + (resultSet.getString("e.Nombre")));
			System.out.println("DIRECCIÓN:" + (resultSet.getString("Dirección")));
			System.out.println("CORREO ELECTRÓNICO:" + (resultSet.getString("Correo_electrónico")));
			System.out.println("-------------------------------------------------");
		}
	}
	/*
	 * public void con() {
	 * 
	 * ResultSet resultSet;
	 * 
	 * try { Conexion conexion = new Conexion("root", "", "universidad_oficial");
	 * 
	 * conexion.
	 * consulta("  SELECT E.cod_Estudiante,C.Nombre,e.Nombre,e.Dirección,e.Correo_electrónico\r\n"
	 * +
	 * "  FROM estudiante e INNER JOIN carrera c ON e.cod_Carrera = c.cod_Carreras\r\n"
	 * + "  GROUP BY e.cod_Estudiante ASC \r\n" + ""); resultSet =
	 * conexion.resultado();
	 * 
	 * while (resultSet.next()) {
	 * 
	 * System.out.println("");
	 * 
	 * System.out.println("CÓDIGO ESTUDIANTE: " +
	 * (resultSet.getInt("cod_Estudiante")));
	 * 
	 * System.out.println("CARRERA: " + (resultSet.getString("c.Nombre")));
	 * 
	 * System.out.println("NOMBRE: " + (resultSet.getString("e.Nombre")));
	 * System.out.println("DIRECCIÓN:" + (resultSet.getString("Dirección")));
	 * System.out.println("CORREO ELECTRÓNICO:" +
	 * (resultSet.getString("Correo_electrónico")));
	 * System.out.println("-------------------------------------------------");
	 * 
	 * } conexion.close(); } catch (ClassNotFoundException e) { e.printStackTrace();
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } }
	 */
}
