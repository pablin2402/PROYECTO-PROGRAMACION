package Aula.view;

import java.sql.SQLException;
import java.util.Scanner;

import Aula.entity.Aula;
import Aula.entity.NoExisteAula;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Men� {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("****************AULA***************");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar aula");
			System.out.println("2. Consultar aula ");
			System.out.println("3. Eliminar aula ");
			System.out.println("4. Modificar aula ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
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

	public static void men�(Scanner scanner, AulasIO aulasView)

			throws SQLException, NoExisteAula {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
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
			System.out.println("--------------------------------------");
			System.out.println("MODIFICAR AULA");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar nombre del aula");
			System.out.println("2. Modificar ubicaci�n del aula ");
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

	public static void men�Modificar(Scanner scanner, Aula aula) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				aula.setNombre(InputTypes.ReadString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				aula.setCod_edificio(InputTypes.readInt("Ingrese el c�digo del nuevo edificio: ", scanner));
				break;
			case 3:
				aula.setPiso(InputTypes.readInt("Ingrese el nuevo piso: ", scanner));
				break;

			}
		}
	}
}
