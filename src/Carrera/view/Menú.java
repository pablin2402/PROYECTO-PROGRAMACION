package Carrera.view;

import java.sql.SQLException;
import java.util.Scanner;

import Carrera.entity.Carrera;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Men� {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar nueva carrera");
			System.out.println("2. Consultar carreras ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men�
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void men�(Scanner scanner, CarrerasIO carrerasView)
			throws SQLException, NoExisteEstudiante, ClassNotFoundException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:

				break;
			case 2:
				carrerasView.list();
				break;
			}
		}
	}

	/****************************
	 * Encabezado del men� *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar nombre de la carrera");
			System.out.println("2. Modificar descripci�n ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void men�Modificar(Scanner scanner, Carrera carrera) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				carrera.setNombre(InputTypes.ReadString("Ingrese el nuevo nombre de la carrera: ", scanner));
				break;

			}
		}
	}
}
