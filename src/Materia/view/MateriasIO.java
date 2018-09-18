package Materia.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;
import Materia.entity.Materia;
import Materia.entity.NoExisteMateria;
import VIEW.InputTypes;

public class MateriasIO {
	private Conexion conexion;
	private Scanner scanner;

	public MateriasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	/*************
	 * Listar materias
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void buscar_materia() throws SQLException, NoExisteMateria {
		ResultSet resultSet;
		Materia materia;

		String Nombre = InputTypes.ReadString("Nombre de la materia: ", scanner);
		String sql = "select * from materia where Nombre = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setString(1, Nombre);
		resultSet = conexion.resultado();

		if (resultSet.next()) {
			int cod_Materia = resultSet.getInt("cod_Materia");
			String Nombre1 = resultSet.getString("Nombre");

			String Fecha_inicio = resultSet.getString("Fecha_Inicio");
			String Fecha_Final = resultSet.getString("Fecha_Final");
			String horarios = resultSet.getString("Horario");
			int Créditos = resultSet.getInt("Créditos");
			int total_a_pagar = resultSet.getInt("total_a_pagar");
			materia = new Materia(cod_Materia, Nombre1, Fecha_inicio, Fecha_Final, horarios, Créditos, total_a_pagar);
		} else {
			throw new NoExisteMateria();
		}
		System.out.println(materia);
	}

	/***********
	 * Listar todas las materias
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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

	/************
	 * Actualiza los datos de la materia
	 * 
	 * @throws NoExisteMateria
	 * @throws SQLException
	 */
	public void upload() throws NoExisteMateria, SQLException {

		ResultSet resultSet;

		Materia materia;
		String nombre;
		String horarios;
		int Créditos;
		int total_a_pagar;

		int cod_Materia = InputTypes.readInt("Código de la materia: ", scanner);

		String sql = "SELECT* FROM materia  WHERE cod_Materia =?";
		System.out.println("Referencia de la materia que se modificará");
		System.out.println("------------------------------------------");
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Materia);
		resultSet = conexion.resultado();

		if (resultSet.next()) {
			nombre = resultSet.getString("Nombre");
			horarios = resultSet.getString("Horario");
			Créditos = resultSet.getInt("Créditos");

			materia = new Materia(cod_Materia, nombre, null, null, horarios, Créditos, cod_Materia);
		} else {
			throw new NoExisteMateria();
		}

		System.out.println(materia);
		Menú.menúModificar(scanner, materia);
		/***
		 * Actualizar materia
		 */
		sql = "UPDATE materia m" + " SET m.Nombre= ?," + "m.Horario= ?," + "m.Créditos=?"
				+ " WHERE m.cod_Materia LIKE ?";

		conexion.consulta(sql);
		conexion.getSentencia().setString(1, materia.getNombre());
		conexion.getSentencia().setString(2, materia.getHorarios());
		conexion.getSentencia().setInt(3, materia.getCreditos());
		conexion.getSentencia().setInt(4, materia.getCod_Materia());
		conexion.modificacion();
	}

	/********
	 * Eliminar materia
	 */
	public void delete() {
		int cod_Materia = InputTypes.readInt("Código de la materia: ", scanner);
		String sql = "delete from materia where cod_Materia = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, cod_Materia);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/***********
	 * Añadir materia
	 */
	public void add() {

		Materia estudiante = MateriaIO.ingresar(scanner);
		String sql = "INSERT INTO materia (cod_Materia, Nombre, Fecha_Inicio, Fecha_Final, Horario, Créditos, total_a_pagar) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Materia());
			conexion.getSentencia().setString(2, estudiante.getNombre());
			conexion.getSentencia().setString(3, estudiante.getFecha_inicio());
			conexion.getSentencia().setString(4, estudiante.getFecha_fin());
			conexion.getSentencia().setString(5, estudiante.getHorarios());
			conexion.getSentencia().setInt(6, estudiante.getCreditos());
			conexion.getSentencia().setInt(7, estudiante.getTotal_a_pagar());

			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
}
