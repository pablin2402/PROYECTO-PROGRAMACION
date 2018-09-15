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
			System.out.println("2. Añadir Alumno nuevo ");
			System.out.println("3. Eliminar Alumno ");
			System.out.println("4. Modificar datos del Alumno ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 * @throws ClassNotFoundException
	 * @throws                        *
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
			System.out.println("1. Modificar Código de carrera");
			System.out.println("2. Modificar dirección");
			System.out.println("3. Modificar el correo electrónico");
			System.out.println("4. Ingrese el código del estudiante al que modificará sus datos");
			System.out.println("0. Salir");
			System.out.println("");

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Estudiante estudiante) {

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

				estudiante.setCod_Carrera(InputTypes.readInt("Ingrese el nuevo código de carrera: ", scanner));
				break;
			case 2:
				estudiante.setDirección(InputTypes.ReadString("Ingrese la nueva dirección del estudiante", scanner));
				break;
			case 3:
				estudiante.setCorreoelectrónico(InputTypes.ReadString("Ingrese el correo electrónico", scanner));
				break;
			case 4:
				estudiante.setCod_Estudiante(InputTypes.readInt("Ingrese su código de estudiante", scanner));
			}
		}
	}
}
