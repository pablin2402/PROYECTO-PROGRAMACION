package VIEW;

import java.sql.SQLException;
import java.util.Scanner;

import Aula.entity.NoExisteAula;
import Aula.view.AulasIO;
import Carrera.view.CarrerasIO;
import Clase.view.ClasesIO;
import Conexion.Conexion;
import Docente.consultas.Actualizar;
import Docente.view.DocentesIO;
import Estudiante.consultas.Consulta;
import Estudiante.entity.NoExisteEstudiante;
import Estudiante.view.EstudiantesIO;
import Materia.view.MateriasIO;

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
	 * @throws NoExisteEstudiante
	 * @throws NoExisteAula *
	 ****************************/

	public static void menú(Scanner scanner)
			throws SQLException, NoExisteEstudiante, NoExisteAula, ClassNotFoundException {
		boolean salir = false;
		Conexion conexion = new Conexion("root", "", "universidad_oficial");

		EstudiantesIO estudiantesIO = new EstudiantesIO(conexion, scanner);
		Consulta consola = new Consulta();
		Actualizar actualizar = new Actualizar();
		AulasIO aulasIO = new AulasIO();
		CarrerasIO carrerasView = new CarrerasIO(conexion, scanner);
		MateriasIO materiasIO = new MateriasIO(conexion, scanner);
		DocentesIO docentesIO = new DocentesIO(conexion, scanner);
		ClasesIO clasesIO = new ClasesIO(conexion, scanner);
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;

			case 1:

				Estudiante.view.Menu.menú(scanner, estudiantesIO, consola);

				break;
			case 2:
				Materia.view.Menú.menú(scanner, materiasIO, consola);
			case 3:
				Docente.view.Menu.menú(scanner, docentesIO, actualizar);
			case 4:
				Clase.view.Menú.menú(scanner, clasesIO, consola);
			case 5:
				Aula.view.Menú.menú(scanner, aulasIO);
			case 6:
				Carrera.view.Menú.menú(scanner, carrerasView);
			}
			conexion.close();
		}

	}
}
