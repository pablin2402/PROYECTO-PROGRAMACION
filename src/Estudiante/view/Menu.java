package Estudiante.view;

import java.sql.SQLException;
import java.util.Scanner;

import Estudiante.consultas.Consulta;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menu {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Consultar Alumno");
			System.out.println("2. Añadir Alumno ");
			System.out.println("3. Eliminar Alumno ");
			System.out.println("4. Modificar Alumno ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void menú(Scanner scanner, EstudiantesIO estudiantesView, Consulta consulta)
			throws SQLException, NoExisteEstudiante, ClassNotFoundException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				estudiantesView.list();
				;
				break;

			}
		}
	}

	/****************************
	 * Encabezado del menú *
	 ****************************/

}

/****************************
 * Opciones del modificar *
 ****************************/
