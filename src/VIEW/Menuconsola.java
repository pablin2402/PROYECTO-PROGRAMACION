package VIEW;

import java.sql.SQLException;
import java.util.Scanner;

import Conexion.Conexion;
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

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 6) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws NoExisteEstudiante *
	 ****************************/

	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException, NoExisteEstudiante {
		boolean salir = false;
		Conexion conexión = new Conexion("root", "", "universidad_oficial");
		EstudiantesIO categoríasIO = new EstudiantesIO(conexión, scanner);
		Consulta consola = new Consulta(conexión, scanner);

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					Estudiante.view.Menu.menú(scanner, categoríasIO, consola);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				Materia.view.Menú.menú(scanner, categoríasIO, consola);
			case 3:
				Docente.view.Menu.menú(scanner, categoríasIO, consola);
			}
		}
		conexión.close();
	}
}
