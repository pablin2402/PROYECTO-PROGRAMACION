package Docente.view;

import java.sql.SQLException;
import java.util.Scanner;

import Docente.consultas.Actualizar;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menu {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Consultar Docentes");
			System.out.println("2. Añadir Docente ");
			System.out.println("3. Eliminar Docente ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
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

	public static void menú(Scanner scanner, DocentesIO docentesView, Actualizar consulta)
			throws SQLException, NoExisteEstudiante, ClassNotFoundException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				docentesView.list();
				break;
			case 2:
				docentesView.add();
				break;
			case 3:
				break;

			}
		}
	}

	/****************************
	 * Encabezado del menú *
	 ****************************/

}
