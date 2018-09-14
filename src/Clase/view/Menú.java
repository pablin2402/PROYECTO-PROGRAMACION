package Clase.view;

import java.sql.SQLException;
import java.util.Scanner;

import Estudiante.consultas.Consulta;
import Estudiante.entity.Estudiante;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menú {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Consultar Inscritos");
			System.out.println("2. Consultar clase ");
			System.out.println("3. Eliminar clase ");
			System.out.println("4. Modificar clase ");

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

	public static void menú(Scanner scanner, ClasesIO clasesView, Consulta consulta)
			throws SQLException, NoExisteEstudiante, ClassNotFoundException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				clasesView.list();
				break;

			}
		}
	}

	/****************************
	 * Encabezado del menú *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar ");
			System.out.println("2. Modificar descripción ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void menúModificar(Scanner scanner, Estudiante estudiante) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				estudiante.setNombre(InputTypes.ReadString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				estudiante.setDirección(InputTypes.ReadString("Ingrese la nueva direccion: ", scanner));
				break;
			case 3:
				estudiante.setCod_Carrera(InputTypes.readInt("Ingrese la nueva carrera: ", scanner));
				break;

			}
		}
	}
}
