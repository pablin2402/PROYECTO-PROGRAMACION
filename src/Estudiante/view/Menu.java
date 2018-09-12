package Estudiante.view;

import java.sql.SQLException;
import java.util.Scanner;

import Estudiante.consultas.Consulta;
import Estudiante.entity.Estudiante;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menu {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Consultar Alumno");
			System.out.println("4. A�adir Alumno ");
			System.out.println("2. Listar Alumnos ");
			System.out.println("3. Eliminar Alumno ");
			System.out.println("4. Modificar Alumno ");
			/**
			 * System.out.println("5. Productos por Categor�a ");
			 */
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
	 * @throws NoExisteEstudiante *
	 ****************************/

	public static void men�(Scanner scanner, EstudiantesIO estudiantesView, Consulta consulta)
			throws SQLException, NoExisteEstudiante {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				consulta.con();
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
			System.out.println("1. Modificar nombre");
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

	public static void men�Modificar(Scanner scanner, Estudiante estudiante) {

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
				estudiante.setDirecci�n(InputTypes.ReadString("Ingrese la nueva direccion: ", scanner));
				break;
			case 3:
				estudiante.setCod_Carrera(InputTypes.readInt("Ingrese la nueva carrera: ", scanner));
				break;

			}
		}
	}
}
