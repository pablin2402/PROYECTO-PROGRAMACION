package Aula.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Aula.entity.Aula;
import Aula.entity.NoExisteAula;
import Conexion.Conexion;
import VIEW.InputTypes;

public class AulasIO {

	private Conexion conexion;
	private Scanner scanner;

	public AulasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	/******
	 * Eliminar aula
	 */
	public void delete() {
		int cod_Aula = InputTypes.readInt("Código del aula: ", scanner);
		String sql = "delete from aula where cod_Aula = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, cod_Aula);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/************
	 * Consultar datos del aula
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void list() throws SQLException, ClassNotFoundException {

		conexion.consulta("SELECT a.cod_Aula, a.cod_Edificio, a.Nombre, a.Piso\r\n" + "  FROM aula a");
		ResultSet resultSet;

		resultSet = conexion.resultado();
		while (resultSet.next()) {

			System.out.println("DATOS DE LAS AULAS EN LA UNIVERSIDAD");
			System.out.println("");
			System.out.println("Código del aula : " + resultSet.getInt("a.cod_Aula"));
			System.out.println("Código del edificio: " + resultSet.getInt("a.cod_Edificio"));
			System.out.println("Nombre del aula: " + resultSet.getString("a.Nombre"));
			System.out.println("Número de Piso: " + resultSet.getInt("a.Piso"));

			System.out.println("---------------------------------------------------------");
		}

	}

	/*******
	 * Actualizar datos del aula
	 * 
	 * @throws SQLException
	 * @throws NoExisteAula
	 */
	public void upload() throws SQLException, NoExisteAula {

		ResultSet resultSet;

		Aula aula;

		int cod_Edificio;
		String Nombre;
		int piso;

		int cod_Aula = InputTypes.readInt("Código del aula: ", scanner);

		String sql = "SELECT* FROM aula  WHERE cod_Aula  =?";
		System.out.println("Referencia de los datos de la inscripción de la materia antes de ser modificadas");
		System.out.println("Esto sería solo para administrador, no para usuario");
		System.out.println("------------------------------------------");

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, cod_Aula);
		resultSet = conexion.resultado();

		if (resultSet.next()) {
			cod_Edificio = resultSet.getInt("cod_Edificio");
			Nombre = resultSet.getString("Nombre");
			piso = resultSet.getInt("Piso");

			aula = new Aula(cod_Edificio, cod_Aula, Nombre, piso);

		} else {
			throw new NoExisteAula();
		}

		System.out.println(aula);
		Menú.menúModificar(scanner, aula);
		/***
		 * Actualizar estudiante
		 */
		sql = "UPDATE aula a " + " SET a.cod_Edificio=?," + " a.Nombre= ?," + "a.Piso=?" + " WHERE a.cod_Aula LIKE ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, aula.getCod_edificio());
		conexion.getSentencia().setString(2, aula.getNombre());
		conexion.getSentencia().setInt(3, aula.getPiso());
		conexion.getSentencia().setInt(4, aula.getCod_Aula());
		conexion.modificacion();
	}

	/*******
	 * FALTA PULIR DETALLES EXCEPCIONES .V
	 */
	public void add() {

		Aula estudiante = AulaIO.ingresar(scanner);
		String sql = "INSERT INTO aula  (cod_Aula, cod_Edificio, Nombre, Piso)" + "values(?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCod_Aula());
			conexion.getSentencia().setInt(2, estudiante.getCod_edificio());
			conexion.getSentencia().setString(3, estudiante.getNombre());
			conexion.getSentencia().setInt(4, estudiante.getPiso());

			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void buscar_aula() throws SQLException, NoExisteAula {
		ResultSet resultSet;
		Aula docente;
		String fecha_entrada;
		int cod_Aula;
		int piso;
		int cod_edificio;
		String nombre = InputTypes.ReadString("Ingrese el nombre del Aula: ", scanner);

		String sql = "select * from aula where Nombre = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setString(1, nombre);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			cod_Aula = resultSet.getInt("cod_Aula");
			cod_edificio = resultSet.getInt("cod_Edificio");
			piso = resultSet.getInt("Piso");

			docente = new Aula(cod_Aula, cod_edificio, nombre, piso);
		} else {
			throw new NoExisteAula();
		}
		System.out.println(docente);
	}
}
