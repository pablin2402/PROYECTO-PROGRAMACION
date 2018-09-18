package Clase.view;

import java.sql.SQLException;
import java.util.Scanner;

import Clase.entity.Clase;
import Clase.entity.NoExisteClase;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menú {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("");
			System.out.println("---------- Clase ----------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("--------------------------- ");
			System.out.println("1. Consultar Inscritos");
			System.out.println("2. Modificar Alumno Inscrito ");
			System.out.println("3. Eliminar Inscrito ");
			System.out.println("4. Inscribir alumno ");
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
	 * @throws NoExisteClase *
	 ****************************/

	public static void menú(Scanner scanner, ClasesIO clasesView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				try {
					clasesView.list();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					clasesView.upload();
				} catch (NoExisteClase e) {
					System.out.println();
					System.out.println("¡No existe la clase!");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 3:
				clasesView.delete();
				break;
			case 4:
				clasesView.add();
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
			System.out.println("---------- MODIFICAR CLASE ----------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------------------------- ");
			System.out.println("1. Modificar Materia");
			System.out.println("2. Modificar Docente");
			System.out.println("3. Modificar Aula");
			System.out.println("4. Ingrese el código de Inscripción");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void menúModificar(Scanner scanner, Clase clase) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				clase.setCod_Materia(InputTypes.readInt("Ingrese el código de materia: ", scanner));
				break;
			case 2:
				clase.setCod_Docente(InputTypes.readInt("Ingrese el código de docente: ", scanner));
				break;
			case 3:
				clase.setCod_Aula(InputTypes.readInt("Ingrese el código de aula: ", scanner));
				break;
			case 4:
				clase.setCod_Inscripción(InputTypes.readInt("Ingrese el código de inscripción", scanner));
				break;

			}
		}
	}
}
