package VIEW;

import java.sql.SQLException;
import java.util.Scanner;

import Aula.entity.NoExisteAula;
import Aula.view.AulasIO;
import Carrera.view.CarrerasIO;
import Conexion.Conexion;
import Docente.consultas.Actualizar;
import Estudiante.consultas.Consulta;
import Estudiante.entity.NoExisteEstudiante;
import Estudiante.view.EstudiantesIO;

public class Menuconsola {
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Alumno");
			System.out.println("2. Materia ");
			System.out.println("3. Docente");
			System.out.println("4. Clase");
			System.out.println("5. Aula");
			System.out.println("6. Carrera");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 6) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men�
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws NoExisteEstudiante
	 * @throws NoExisteAula *
	 ****************************/

	public static void men�(Scanner scanner)
			throws ClassNotFoundException, SQLException, NoExisteEstudiante, NoExisteAula {
		boolean salir = false;
		Conexion conexi�n = new Conexion("root", "", "universidad_oficial");
		EstudiantesIO categor�asIO = new EstudiantesIO(conexi�n, scanner);
		Consulta consola = new Consulta();
		Actualizar actualizar = new Actualizar();
		AulasIO aulasIO = new AulasIO();
		CarrerasIO carrerasView = new CarrerasIO();

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;

			case 1:
				try {
					Estudiante.view.Menu.men�(scanner, categor�asIO, consola);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				Materia.view.Men�.men�(scanner, categor�asIO, consola);
			case 3:
				Docente.view.Menu.men�(scanner, categor�asIO, actualizar);
			case 4:
				Clase.view.Men�.men�(scanner, categor�asIO, consola);
			case 5:
				Aula.view.Men�.men�(scanner, aulasIO);
			case 6:
				Carrera.view.Men�.men�(scanner, carrerasView);
			}
		}
		conexi�n.close();
	}
}
