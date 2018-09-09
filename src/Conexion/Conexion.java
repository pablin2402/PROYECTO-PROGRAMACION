package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {

	private Connection conn = null;
	private PreparedStatement sentencia = null;
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	/*
	 * Ruta de la base de datos
	 * 
	 */
	private static String DB_URL = "jdbc:mariadb://127.0.0.1/";

	/**
	 * 
	 * @param usuario
	 * @param password
	 * @param dataBase
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Conexion(String user, String password, String dataBase) throws ClassNotFoundException, SQLException {

		// Database credentials

		/**
		 * Paso 2: Registrar JDBC driver
		 */
		Class.forName(JDBC_DRIVER);

		// Paso 3: Abrir la coneccion
		JOptionPane.showMessageDialog(null, "Conectado correctamente a la base de datos UNIVERSIDAD");
		DB_URL = DB_URL + dataBase;
		/**
		 * Establece conexion con la base de datos
		 */
		conn = DriverManager.getConnection(DB_URL, user, password);
	}

	public void consulta(String sql) throws SQLException {
		sentencia = conn.prepareStatement(sql);
	}

	public ResultSet resultado() throws SQLException {
		return sentencia.executeQuery();
	}

	public int modificacion() throws SQLException {
		return sentencia.executeUpdate();

	}

	public void close() throws SQLException {
		if (sentencia != null) {
			sentencia.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public PreparedStatement getSentencia() {
		return sentencia;
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}

}
