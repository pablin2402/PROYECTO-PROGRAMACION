package update;

import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;

public class Update {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			Conexion conexion = new Conexion("root", "", "universidad");
			conexion.consulta(
					"UPDATE ESTUDIANTES " + "SET ESTUDIANTE = ?," + " DIRECCION=? " + " WHERE ESTUDIANTE LIKE ? ");
			String producto = InputTypes.ReadString("Ingrese el nuevo nombre", scanner);
			String direccion = InputTypes.ReadString("Ingrese la nueva direccion", scanner);
			String productoCondiciòn = InputTypes.ReadString("Ingrese la condicion", scanner);
			/***
			 * Parametros son secuenciales comienzan en 1
			 * 
			 */
			conexion.getSentencia().setString(1, producto);
			conexion.getSentencia().setString(2, direccion);
			conexion.getSentencia().setString(3, productoCondiciòn);

			conexion.modificacion();
			conexion.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
