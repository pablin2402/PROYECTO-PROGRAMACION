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
			System.out.println("2. A�adir Alumno nuevo ");
			System.out.println("3. Eliminar Alumno ");
			System.out.println("4. Modificar datos del Alumno ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men�
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 * @throws ClassNotFoundException
	 * @throws                        *
	 ****************************/

	public static void men�(Scanner scanner, EstudiantesIO estudiantesView, Consulta consulta)
			throws SQLException, NoExisteEstudiante, ClassNotFoundException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				estudiantesView.list();

				break;
			case 2:
				estudiantesView.add();
				break;
			case 3:
				break;
			case 4:
				estudiantesView.upload();
				break;
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar C�digo de carrera");
			System.out.println("2. Modificar direcci�n");
			System.out.println("3. Modificar el correo electr�nico");
			System.out.println("4. Ingrese el c�digo del estudiante al que modificar� sus datos");
			System.out.println("0. Salir");
			System.out.println("");

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void men�Modificar(Scanner scanner, Estudiante estudiante) {

		boolean salir = false;
		/****
		 * NOTA: FALTA EXCEPCION PARA CODIGO DE CARRERA
		 * 
		 */
		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:

				estudiante.setCod_Carrera(InputTypes.readInt("Ingrese el nuevo c�digo de carrera: ", scanner));
				break;
			case 2:
				estudiante.setDirecci�n(InputTypes.ReadString("Ingrese la nueva direcci�n del estudiante", scanner));
				break;
			case 3:
				estudiante.setCorreoelectr�nico(InputTypes.ReadString("Ingrese el correo electr�nico", scanner));
				break;
			case 4:
				estudiante.setCod_Estudiante(InputTypes.readInt("Ingrese su c�digo de estudiante", scanner));
			}
		}
	}
}
