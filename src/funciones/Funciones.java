package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;

public class Funciones {
	private Connection connection = null;
	private final Connection conexion = connection.getConexion();
	private static PreparedStatement sentencia = null;

	public static boolean Registrar(Sentencia a) {
		String sql = Sentencia.REGISTRAR;
		ResultSet resultSet;

		try {

			Conexion conexion = new Conexion("root", "", "neptuno");
			conexion.consulta("SELECT PRODUCTO,PRECIO_UNIDAD, PROVEEDOR_ID FROM PRODUCTOS");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				sentencia = conexion.PreparedStatement(sql);

			}
			conexion.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
