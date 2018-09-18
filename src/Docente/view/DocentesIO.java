package Docente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;
import Docente.entity.Docente;
import Docente.entity.NoExisteDocente;
import VIEW.InputTypes;

public class DocentesIO {
	private Conexion conexion;
	private Scanner scanner;

	public DocentesIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	/***********
	 * Listar docentes
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta(
				" SELECT d.cod_Docente,d.fecha_entrada,d.Nombre,d.fecha_nacimiento,d.Carrera\r\n" + "FROM docentes d");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DEL DOCENTE");
			System.out.println("");
			System.out.println("Código Docente: " + resultSet.getInt("d.cod_Docente"));
			System.out.println("Fecha de Entrada: " + resultSet.getString("d.fecha_entrada"));
			System.out.println("Nombre: " + resultSet.getString("d.Nombre"));
			System.out.println("Fecha de Nacimiente: " + resultSet.getString("d.fecha_nacimiento"));
			System.out.println("Carrera: " + resultSet.getString("d.Carrera"));

			System.out.println("---------------------------------------------------------");
		}
	}

	/*********
	 * Eliminar docente
	 */
	public void delete() {
		int cod_Docente = InputTypes.readInt("Código del docente: ", scanner);
		String sql = "delete from docentes where cod_Docente = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, cod_Docente);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************
	 * AÑADIR DOCENTE
	 */
	public void add() {

		Docente estudiante = DocenteIO.ingresar(scanner);
		String sql = "INSERT INTO docentes (cod_Docente, fecha_entrada, Nombre, fecha_nacimiento, Carrera, `C.I`) "
				+ "values(?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Docente());
			conexion.getSentencia().setString(2, estudiante.getFecha_entrada());
			conexion.getSentencia().setString(3, estudiante.getNombre());
			conexion.getSentencia().setString(4, estudiante.getFecha_nacimiento());
			conexion.getSentencia().setString(5, estudiante.getCarrera());
			conexion.getSentencia().setInt(6, estudiante.getCI());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void buscar_docente() throws SQLException, NoExisteDocente {
		ResultSet resultSet;
		Docente docente;
		String fecha_entrada;
		String fecha_nacimiento;
		String carrera;
		int cI;
		String nombre;

		int cod_Docente = InputTypes.readInt("Código del docente: ", scanner);
		String sql = "select * from docentes where cod_Docente = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Docente);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			fecha_entrada = resultSet.getString("fecha_entrada");
			nombre = resultSet.getString("Nombre");
			fecha_nacimiento = resultSet.getString("fecha_nacimiento");
			carrera = resultSet.getString("Carrera");
			cI = resultSet.getInt("C.I");
			docente = new Docente(cod_Docente, fecha_entrada, nombre, fecha_nacimiento, carrera, cI);
		} else {
			throw new NoExisteDocente();
		}
		System.out.println(docente);
	}
}