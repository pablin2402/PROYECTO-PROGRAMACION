package Carrera.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Carrera.entity.Carrera;
import Conexion.Conexion;

public class CarrerasIO {

	private Conexion conexion;
	private Scanner scanner;

	public CarrerasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta("SELECT c.cod_Carreras, c.Nombre\r\n" + "FROM carrera c");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("*********CARRERAS**********");
			System.out.println("");
			System.out.println("Código de la Carrera : " + resultSet.getString("c.cod_Carreras"));
			System.out.println("Nombre de la Carrera : " + resultSet.getString("c.Nombre"));

			System.out.println("---------------------------------------------------------");
		}

	}

	public void add() {

		Carrera estudiante = CarreraIO.ingresar(scanner);
		String sql = "INSERT INTO carrera (cod_Carreras, Nombre) " + "values(?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Carrera());
			conexion.getSentencia().setString(2, estudiante.getNombre());

			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

}
